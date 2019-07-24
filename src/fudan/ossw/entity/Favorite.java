package fudan.ossw.entity;


import java.sql.Timestamp;

public class Favorite {
    int favoriteID;
    int userID;
    int artID;
    Timestamp addTime;

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

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

}
