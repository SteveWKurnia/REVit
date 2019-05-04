package android.wk.com.revit.DataModels;

import java.util.ArrayList;

public class User {

    private String userName;
    private String name;
    private Integer profilePicture;
    private String email;
    private ArrayList<Review> recentReview;

    public User(String userName, String name, Integer profilePicture, String email, ArrayList<Review> recentReview) {
        this.userName = userName;
        this.name = name;
        this.profilePicture = profilePicture;
        this.email = email;
        this.recentReview = recentReview;
    }

    public ArrayList<Review> getRecentReview() {
        return recentReview;
    }
    public void setRecentReview(ArrayList<Review> recentReview) {
        this.recentReview = recentReview;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(Integer profilePicture) {
        this.profilePicture = profilePicture;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
