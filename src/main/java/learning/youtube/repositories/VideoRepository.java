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

    public Video getOne(int videoId){
        String sql = "SELECT * FROM videos WHERE id = ?";
        RowMapper<Video> rowMapper = new VideoRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, videoId);
    }


    public void addVideo(Video video){

        String sql = "INSERT INTO videos (title, length, num_upvotes, num_downvotes, playlist_id, uploader_id) VALUES (?, ?, 0, 0, ?, ?)";

        jdbcTemplate.update(sql, video.getTitle(), video.getLength(), video.getPlaylistId(), video.getUploaderId());

        String sql2 = "SELECT id FROM videos WHERE title = ? AND length = ? AND playlist_id = ? AND uploader_id = ?";
        int videoId = jdbcTemplate.queryForObject(sql2, Integer.class, video.getTitle(), video.getLength(), video.getPlaylistId(), video.getUploaderId());

        video.setId(videoId);
    }

    public void updateVideo(Video video){
        String sql = "UPDATE videos SET title = ?, length = ?, playlist_id = ?, num_upvotes = ?, num_downvotes = ?  WHERE id = ?";
        jdbcTemplate.update(sql, video.getTitle(), video.getLength(), video.getPlaylistId(), video.getNumUpvotes(), video.getNumDownvotes(), video.getId());
    }

    public void deleteVideo(int videoId){
        String sql = "DELETE FROM videos WHERE id = ?";
        jdbcTemplate.update(sql, videoId);
    }

    public boolean videoExists(int videoId) {
        String sql = "SELECT count(*) FROM videos WHERE id =?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, videoId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
}