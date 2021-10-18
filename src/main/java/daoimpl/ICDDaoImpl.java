package daoimpl;

import dao.ICDDao;
import mapper.ICDMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.ICD;

import javax.sql.DataSource;
import java.util.List;

public class ICDDaoImpl implements ICDDao {
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
    public int setICD(ICD icd) {
        String SQL = "insert into "+dbname+"([index],code,Description) values (?,?,?)";
        return jdbcTemplateObject.update( SQL, icd.getIndex(), icd.getCode(), icd.getDescription());
    }

    @Override
    public ICD getICD(long index) {
        String SQL = "select * from "+dbname+" where [index] = ?";
        ICD icd = jdbcTemplateObject.queryForObject(SQL, new ICDMapper(), index);

        return icd;
    }

    @Override
    public List<ICD> getICDFromCode(String code) {
        String SQL = "select * from "+dbname+" where Code = ?";
        List<ICD> icdList = jdbcTemplateObject.query(SQL, new ICDMapper(), code);
        return icdList;
    }

    @Override
    public List<ICD> getAllICD() {
        String SQL = "select * from "+dbname;
        List<ICD> icdList = jdbcTemplateObject.query(SQL, new ICDMapper());
        return icdList;
    }

    @Override
    public void deleteICD(long index) {
        String SQL = "delete from "+dbname+" where [index] = ?";
        jdbcTemplateObject.update(SQL, index);
        System.out.println("Deleted Record with Index = " + index );
    }


}
