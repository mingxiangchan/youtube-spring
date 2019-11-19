package learning.youtube.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 


public class UploaderRowMapper implements RowMapper<Uploader> {

    @Override
    public Uploader mapRow(ResultSet row, int rowNum) throws SQLException {
     Uploader x = new Uploader();
     x.setId(row.getInt("id"));
     x.setName(row.getString("name"));
     x.setEmail(row.getString("email"));
     return x;
    }
}