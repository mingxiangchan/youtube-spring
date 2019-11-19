package learning.youtube.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.youtube.models.Playlist;
import learning.youtube.models.PlaylistRowMapper;

@Transactional
@Repository
public class PlaylistRepository {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PlaylistRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Playlist> getAll() {
        String sql = "SELECT * FROM playlists";
        RowMapper<Playlist> rowMapper = new PlaylistRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 
    
}