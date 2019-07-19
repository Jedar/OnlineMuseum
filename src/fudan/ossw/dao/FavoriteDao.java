package fudan.ossw.dao;

import fudan.ossw.entity.Favorite;

import java.util.List;

public interface FavoriteDao {
    public List<Favorite> getFavoriteList(int userID);

    public List<Favorite> getWhoFavorite(int artworkID);

    public boolean addFavorite(int userID, int artworkID);

    public void cancelFavorite(int userID, int artworkID);

    public int getFavoriteCount(int userID);
}
