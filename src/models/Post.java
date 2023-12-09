package models;

public class Post {
    private int postId;
    private String imageUrl;
    private String description;

    public Post() {
    }

    public Post(int postId, String imageUrl, String description) {
        this.postId = postId;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPostId() {
        return postId;
    }

    public Post setPostId(int postId) {
        this.postId = postId;
        return null;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
