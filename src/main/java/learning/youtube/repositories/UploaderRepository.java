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

    public Uploader getOne(int uploaderId){
        String sql = "SELECT * FROM uploaders WHERE id = ?";
        RowMapper<Uploader> rowMapper = new UploaderRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, uploaderId);
    }

    public int getOneByEmail(String email){
        String sql = "SELECT COUNT(*) FROM playlists WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, email);
    }

    public void addUploader(Uploader uploader){
        String sql = "INSERT INTO uploaders (name, email) VALUES (?, ?)";

        jdbcTemplate.update(sql, uploader.getName(), uploader.getEmail());

        String sql2 = "SELECT id FROM uploaders WHERE email = ?";

        int uploaderId = jdbcTemplate.queryForObject(sql2, Integer.class, uploader.getEmail());
        uploader.setId(uploaderId);
    }

    public void updateUploader(Uploader uploader){
        String sql = "UPDATE uploaders SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, uploader.getName(), uploader.getEmail(), uploader.getId());
    }

    public void deleteUploader(int uploaderId){
        String sql = "DELETE FROM uploaders WHERE id = ?";
        jdbcTemplate.update(sql, uploaderId);
    }

    public boolean uploaderExists(int uploaderId) {
        String sql = "SELECT count(*) FROM uploaders WHERE id =?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, uploaderId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
    
}