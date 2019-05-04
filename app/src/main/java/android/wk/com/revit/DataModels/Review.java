package android.wk.com.revit.DataModels;

import java.util.ArrayList;

public class Review {

    private ArrayList<User> upvotedBy;
    private ArrayList<User> downvotedBy;
    private User poster;
    private String content;

    public Review(ArrayList<User> upvotedBy, ArrayList<User> downvotedBy, User poster, String content) {
        this.upvotedBy = upvotedBy;
        this.downvotedBy = downvotedBy;
        this.poster = poster;
        this.content = content;
    }

    public ArrayList<User> getUpvotedBy() {
        return upvotedBy;
    }
    public void setUpvotedBy(ArrayList<User> upvotedBy) {
        this.upvotedBy = upvotedBy;
    }
    public ArrayList<User> getDownvotedBy() {
        return downvotedBy;
    }
    public void setDownvotedBy(ArrayList<User> downvotedBy) {
        this.downvotedBy = downvotedBy;
    }
    public User getPoster() {
        return poster;
    }
    public void setPoster(User poster) {
        this.poster = poster;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
