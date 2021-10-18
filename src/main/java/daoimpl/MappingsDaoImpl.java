package daoimpl;

import dao.HCCDao;
import dao.ICDDao;
import dao.MappingsDao;
import mapper.HCCMapper;
import mapper.ICDMapper;
import mapper.MappingsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.HCC;
import pojo.ICD;
import pojo.Mappings;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class MappingsDaoImpl implements MappingsDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    HCCDao hccDao;
    ICDDao icdDao;

    private String dbname;
    private String hccDBName;
    private String icdDBName;

    public void setHccDao(HCCDao hccDao) {
        this.hccDao = hccDao;
    }

    public void setIcdDao(ICDDao icdDao) {
        this.icdDao = icdDao;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public void setHCCDBName(String hccDBName) {
        this.hccDBName = hccDBName;
    }

    @Override
    public void setICDDBName(String icdDBName) {
        this.icdDBName = icdDBName;
    }

    @Override
    public List<HCC> getMappedHCC(ICD icd) {
        String fromCode = icd.getCode();
        String SQL = "Select hcc.* FROM "+hccDBName+" as hcc  join "+ dbname+" as m where hcc.Code = m.ToCode and m.FromCode = ?";
        return jdbcTemplateObject.query(SQL, new HCCMapper(), fromCode);
    }

    @Override
    public List<ICD> getMappedICD(HCC hcc) {
        String toCode = hcc.getCode();
        String SQL = "Select icd.* FROM "+icdDBName+" as icd  join "+ dbname+" as m where icd.Code = m.FromCode and m.ToCode = ?";
        return jdbcTemplateObject.query(SQL, new ICDMapper(), toCode);
    }

    @Override
    public int setMapping(Mappings mappings) {
        String SQL = "insert into "+dbname+"([index],FromCode,FromSystem,ToCode,ToSystem) values (?,?,?,?,?)";
        return jdbcTemplateObject.update( SQL, mappings.getIndex(), mappings.getFromCode(), mappings.getFromSystem(),
                mappings.getToCode(), mappings.getToSystem());
    }

    @Override
    public void deleteMapping(long index) {
        String SQL = "delete from "+dbname+" where [index] = ?";
        jdbcTemplateObject.update(SQL, index);
        System.out.println("Deleted Record with Index = " + index );
    }
}
