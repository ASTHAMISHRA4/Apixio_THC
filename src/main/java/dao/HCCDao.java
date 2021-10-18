package dao;

import pojo.HCC;

import javax.sql.DataSource;
import java.util.List;

public interface HCCDao {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    void setDbname(String dbname);

    int setHCC(HCC hcc);

    HCC getHCC(long index);

    List<HCC> getHCCFromCode(String code);

    List<HCC> getAllHCC();

    void deleteHCC(long index);

    public List<HCC> getChilden(HCC hcc);

    public List<HCC> getParent(HCC hcc);
}
