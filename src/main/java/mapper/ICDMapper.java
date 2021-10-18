package mapper;

import org.springframework.jdbc.core.RowMapper;
import pojo.ICD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ICDMapper implements RowMapper<ICD> {
    public ICD mapRow(ResultSet rs, int rowNum) throws SQLException {
        ICD icd = new ICD();
        icd.setIndex(rs.getLong("index"));
        icd.setCode(rs.getString("Code"));
        icd.setDescription(rs.getString("Description"));

        return icd;
    }
}
