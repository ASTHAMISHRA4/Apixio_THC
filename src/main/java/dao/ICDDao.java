package dao;

import mapper.HCCMapper;
import pojo.HCC;
import pojo.ICD;

import javax.sql.DataSource;
import java.util.List;

public interface ICDDao {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    void setDbname(String dbname);

    int setICD(ICD icd);

    ICD getICD(long index);

    List<ICD> getICDFromCode(String code);

    List<ICD> getAllICD();

    void deleteICD(long index);
}
