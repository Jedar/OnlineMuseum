package fudan.ossw.dao;

import java.util.List;

public interface FavoriteDao {
    public List<Integer> getFavoriteList(int userID);

    public boolean addFavorite(int userID, int artworkID);

    public void cancelFavorite(int favorID);
}
