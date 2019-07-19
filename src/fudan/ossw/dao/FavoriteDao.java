package fudan.ossw.dao;

import fudan.ossw.entity.Favorite;

import java.util.List;

public interface FavoriteDao {
    public List<Favorite> getFavoriteList(int userID);

    public boolean addFavorite(int userID, int artworkID);

    public void cancelFavorite(int favorID);
}
