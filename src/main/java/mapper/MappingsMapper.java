package mapper;

import org.springframework.jdbc.core.RowMapper;
import pojo.Mappings;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappingsMapper implements RowMapper<Mappings> {
    public Mappings mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mappings mappings = new Mappings();
        mappings.setIndex(rs.getLong("index"));
        mappings.setFromCode(rs.getString("FromCode"));
        mappings.setFromSystem(rs.getString("FromSystem"));
        mappings.setToSystem(rs.getString("ToSystem"));
        mappings.setToCode(rs.getString("ToCode"));
        return mappings;
    }
}
