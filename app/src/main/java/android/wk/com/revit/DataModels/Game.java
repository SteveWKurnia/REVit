package android.wk.com.revit.DataModels;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    private String category;
    private Integer gameIcon;
    private Integer gamePoster;
    private String title;
    private Integer likeCount;
    private Integer dislikeCount;
    private ArrayList<Review> reviews;


    public Game(String category, Integer gameIcon, Integer gamePoster, String title, Integer likeCount, Integer dislikeCount, ArrayList<Review> reviews) {
        this.category = category;
        this.gameIcon = gameIcon;
        this.gamePoster = gamePoster;
        this.title = title;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.reviews = reviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getGameIcon() {
        return gameIcon;
    }
    public void setGameIcon(Integer gameIcon) {
        this.gameIcon = gameIcon;
    }
    public Integer getGamePoster() {
        return gamePoster;
    }
    public void setGamePoster(Integer gamePoster) {
        this.gamePoster = gamePoster;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
    public Integer getDislikeCount() {
        return dislikeCount;
    }
    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
}
