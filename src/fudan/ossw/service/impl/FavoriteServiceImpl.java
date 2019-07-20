package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.Favorite;
import fudan.ossw.service.FavoriteService;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName FavoriteServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 21:47
 * @Version 1.0
 **/
public class FavoriteServiceImpl implements FavoriteService {
    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public List<Artwork> getFavoriteList(int userID) {
        List<Favorite> favorites = DaoFactory.getInstance().getFavoriteDao().getFavoriteList(userID);
        List<Artwork> artworks = new LinkedList<>();
        for(Favorite favorite : favorites) {
            artworks.add(DaoFactory.getInstance().getArtworkDao().getArtwork(favorite.getArtID()));
        }
        return artworks;
    }

    @Override
    public boolean deleteFavorite(int userID, int artworkID) {
        return DaoFactory.getInstance().getFavoriteDao().cancelFavorite(userID, artworkID);
    }
}
