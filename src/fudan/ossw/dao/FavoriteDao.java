package fudan.ossw.dao;

import fudan.ossw.entity.Favorite;

import java.util.List;

public interface FavoriteDao {

    public Favorite getFavorite(int userID, int artworkID);

    public List<Favorite> getFavoriteList(int userID);

    public List<Favorite> getRecentFavorite(int userID);

    public List<Favorite> getWhoFavorite(int artworkID);

    public boolean addFavorite(int userID, int artworkID);

    public boolean cancelFavorite(int userID, int artworkID);

    public int getFavoriteCount(int userID);

    public boolean changeVisibility(int userID, int artworkID, boolean visible);
}
