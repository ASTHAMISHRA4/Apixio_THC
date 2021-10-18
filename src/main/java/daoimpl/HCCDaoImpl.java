package daoimpl;

import dao.HCCDao;
import mapper.HCCMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.HCC;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HCCDaoImpl implements HCCDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String dbname;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    @Override
    public int setHCC(HCC hcc) {
        String SQL = "insert into "+dbname+"([index],code,RAF,Children,Description) values (?,?,?,?,?)";
        return jdbcTemplateObject.update( SQL, hcc.getIndex(), hcc.getCode(), hcc.getRaf(), hcc.getChildren(),
                hcc.getDescription());
    }

    @Override
    public HCC getHCC(long index) {
        String SQL = "select * from "+dbname+" where [index] = ?";
        HCC hcc = jdbcTemplateObject.queryForObject(SQL,
                new HCCMapper(), index);

        return hcc;
    }

    @Override
    public List<HCC> getHCCFromCode(String code) {
        String SQL = "select * from "+dbname+" where Code = ?";
        List<HCC> hccList = jdbcTemplateObject.query(SQL, new HCCMapper(), code);

        return hccList;
    }

    @Override
    public List<HCC> getAllHCC() {
        String SQL = "select * from "+dbname;
        List<HCC> hccList = jdbcTemplateObject.query(SQL, new HCCMapper());
        return hccList;
    }

    @Override
    public void deleteHCC(long index) {
        String SQL = "delete from "+dbname+" where [index] = ?";
        jdbcTemplateObject.update(SQL, index);
        System.out.println("Deleted Record with Index = " + index );
    }

    public List<HCC> getChilden(HCC hcc)
    {
        String SQL = "select Children from "+dbname+" where [index] = ?";
        System.out.println("for "+hcc.toString());
        String children = jdbcTemplateObject.queryForObject(SQL, String.class, hcc.getIndex());
        System.out.println("Returened children "+children);
        List<HCC> hccList = new ArrayList<>();
        if(children != null)
        {
            children = children.replace("[", "").replace("]","")
                    .replace("'","");
            List<String> childrens= Stream.of(children.split(",")).map(String::trim)
                    .collect(toList());
            for(String code : childrens)
            {
                String queryHCC = "select * from "+dbname+" where Code = ?";
                hccList.addAll(jdbcTemplateObject.query(queryHCC, new HCCMapper(), code));
            }
        }
        return hccList;
    }

    public List<HCC> getParent(HCC hcc)
    {
        hcc = getHCC(hcc.getIndex());
        List<HCC> parentList = new ArrayList<>();
        List<HCC> allHCc = getAllHCC();
        for(HCC hcc1 : allHCc)
        {
            List<HCC> childrenList = getChilden(hcc1);
            for(HCC children : childrenList)
            {
                System.out.println("if "+children + " is equal to "+hcc);
                if(children.equals(hcc))
                {
                    parentList.add(hcc1);
                    System.out.println("true");
                }
            }
        }
        return parentList;
    }
}
