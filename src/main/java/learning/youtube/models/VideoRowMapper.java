package learning.youtube.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper; 


public class VideoRowMapper implements RowMapper<Video> {

    @Override
    public Video mapRow(ResultSet row, int rowNum) throws SQLException {
     Video x = new Video();
     x.setId(row.getInt("id"));
     x.setTitle(row.getString("title"));
     x.setLength(row.getInt("length"));
     x.setNumUpvotes(row.getInt("num_upvotes"));
     x.setNumDownvotes(row.getInt("num_downvotes"));
     x.setPlaylistId(row.getInt("playlist_id"));
     x.setUploaderId(row.getInt("uploader_id"));
     return x;
    }
}