package fudan.ossw.dao.impl;

import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.entity.Favorite;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    @Override
    public List<Favorite> getFavoriteList(int userID) {
        return null;
    }

    @Override
    public boolean addFavorite(int userID, int artworkID) {
        return false;
    }

    @Override
    public void cancelFavorite(int favorID) {

    }
}
