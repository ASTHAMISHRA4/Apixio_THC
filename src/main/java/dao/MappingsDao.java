package dao;

import pojo.HCC;
import pojo.ICD;
import pojo.Mappings;

import javax.sql.DataSource;
import java.util.List;

public interface MappingsDao {
    HCCDao hccDao = null;
    ICDDao icdDao = null;
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    void setDbname(String dbname);

    public void setHCCDBName(String hccDBName);

    public void setICDDBName(String icdDBName);

    List<HCC> getMappedHCC(ICD icd);

    List<ICD> getMappedICD(HCC hcc);

    int setMapping(Mappings mappings);

    void deleteMapping(long index);

    void setHccDao(HCCDao hccDao);

    void setIcdDao(ICDDao icdDao);
}
