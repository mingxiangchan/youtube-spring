package learning.youtube.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 


public class PlaylistRowMapper implements RowMapper<Playlist> {

    @Override
    public Playlist mapRow(ResultSet row, int rowNum) throws SQLException {
     Playlist x = new Playlist();
     x.setId(row.getInt("id"));
     x.setTitle(row.getString("title"));
     return x;
    }
}