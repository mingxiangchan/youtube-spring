package learning.youtube.models;

public class Uploader {
    private int id;
    private String name;
    private String email;

    // this is good
    // private int numUpvotes;

    // this is bad
    // private int num_upvotes

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}