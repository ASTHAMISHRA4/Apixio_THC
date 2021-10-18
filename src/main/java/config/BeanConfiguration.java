package config;

import dao.HCCDao;
import dao.ICDDao;
import dao.MappingsDao;
import daoimpl.HCCDaoImpl;
import daoimpl.ICDDaoImpl;
import daoimpl.MappingsDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BeanConfiguration {

    static String DB_NAME = "org.sqlite.JDBC";
    static String DB_PATH = "takehome_mapping_sqlite.db";
    static String DB_DRIVER = "jdbc:sqlite:"+ DB_PATH;
    static String HCC_DB_NAME = "codes_hccv24";
    static String ICD_DB_NAME = "codes_icd10";
    static String MAPPINGS_DB_NAME = "mappings";

    @Bean
    public DriverManagerDataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_NAME);
        dataSource.setUrl(DB_DRIVER);
        return dataSource;
    }

    @Bean
    public HCCDao getHCCDao()
    {
        HCCDao hccDao = new HCCDaoImpl();
        hccDao.setDataSource(getDataSource());
        hccDao.setDbname(HCC_DB_NAME);
        return hccDao;
    }

    @Bean
    public ICDDao getICDDao()
    {
        ICDDao icdDao = new ICDDaoImpl();
        icdDao.setDataSource(getDataSource());
        icdDao.setDbname(ICD_DB_NAME);
        return icdDao;
    }

    @Bean
    public MappingsDao getMappingsDao()
    {
        MappingsDao mappingsDao = new MappingsDaoImpl();
        mappingsDao.setDataSource(getDataSource());
        mappingsDao.setDbname(MAPPINGS_DB_NAME);
        mappingsDao.setHCCDBName(HCC_DB_NAME);
        mappingsDao.setICDDBName(ICD_DB_NAME);
        mappingsDao.setHccDao(getHCCDao());
        mappingsDao.setIcdDao(getICDDao());
        return mappingsDao;
    }
}
