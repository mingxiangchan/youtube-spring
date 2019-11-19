package learning.youtube.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.youtube.models.Video;
import learning.youtube.models.VideoRowMapper;

@Transactional
@Repository
public class VideoRepository {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public VideoRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Video> getAll() {
        String sql = "SELECT * FROM videos";
        RowMapper<Video> rowMapper = new VideoRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 
    
}