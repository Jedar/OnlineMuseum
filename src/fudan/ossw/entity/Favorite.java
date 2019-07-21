package fudan.ossw.entity;

import java.sql.Date;

/**
 * @ClassName Favorite
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/17 10:26
 * @Version 1.0
 **/
public class Favorite {
    int favoriteID;
    int userID;
    int artID;
    Date addTime;

    public Favorite() {
    }

    public Favorite(int favoriteID, int userID, int artID) {
        this.favoriteID = favoriteID;
        this.userID = userID;
        this.artID = artID;
    }

    public int getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(int favoriteID) {
        this.favoriteID = favoriteID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}
