package learning.youtube.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.youtube.models.Uploader;
import learning.youtube.models.UploaderRowMapper;

@Transactional
@Repository
public class UploaderRepository {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UploaderRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Uploader> getAll() {
        String sql = "SELECT * FROM uploaders";
        RowMapper<Uploader> rowMapper = new UploaderRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 
    
}