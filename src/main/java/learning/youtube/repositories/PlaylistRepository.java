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

    public Playlist getOne(int playlistId){
        String sql = "SELECT * FROM playlists WHERE id = ?";
        RowMapper<Playlist> rowMapper = new PlaylistRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, playlistId);
    }

    public int getOneByTitle(String title){
        String sql = "SELECT COUNT(*) FROM playlists WHERE title = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, title);
    }

    public void addPlaylist(Playlist playlist){
        String sql = "INSERT INTO playlists (title) VALUES (?)";

        jdbcTemplate.update(sql, playlist.getTitle());

        String sql2 = "SELECT id FROM playlists WHERE title = ?";
        int playlistId = jdbcTemplate.queryForObject(sql2, Integer.class, playlist.getTitle());

        playlist.setId(playlistId);
    }

    public void updatePlaylist(Playlist playlist){
        String sql = "UPDATE playlists SET title = ? WHERE id = ?";
        jdbcTemplate.update(sql, playlist.getTitle(), playlist.getId());
    }

    public void deletePlaylist(int playlistId){
        String sql = "DELETE FROM playlists WHERE id = ?";
        jdbcTemplate.update(sql, playlistId);
    }

    public boolean playlistExists(int playlistId) {
        String sql = "SELECT count(*) FROM playlists WHERE id =?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, playlistId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
    
}