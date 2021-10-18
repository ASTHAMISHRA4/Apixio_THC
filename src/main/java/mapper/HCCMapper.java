package mapper;

import org.springframework.jdbc.core.RowMapper;
import pojo.HCC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HCCMapper implements RowMapper<HCC> {
    public HCC mapRow(ResultSet rs, int rowNum) throws SQLException {
        HCC hcc = new HCC();
        hcc.setIndex(rs.getLong("index"));
        hcc.setCode(rs.getString("Code"));
        hcc.setDescription(rs.getString("Description"));
        hcc.setChildren(rs.getString("Children"));
        hcc.setRaf(rs.getDouble("RAF"));

        return hcc;
    }
}
