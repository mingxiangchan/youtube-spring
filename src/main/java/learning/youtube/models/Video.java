package learning.youtube.models;

public class Video {
    private int id;
    private String title;
    private int length;
    private int numUpvotes;
    private int numDownvotes;
    private int playlistId;
    private int uploaderId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumUpvotes() {
        return this.numUpvotes;
    }

    public void setNumUpvotes(int numUpvotes) {
        this.numUpvotes = numUpvotes;
    }

    public int getNumDownvotes() {
        return this.numDownvotes;
    }

    public void setNumDownvotes(int numDownvotes) {
        this.numDownvotes = numDownvotes;
    }

    public int getPlaylistId() {
        return this.playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUploaderId() {
        return this.uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

}