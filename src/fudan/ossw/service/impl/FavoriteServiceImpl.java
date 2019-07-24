package fudan.ossw.service.impl;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;
import fudan.ossw.entity.Favorite;
import fudan.ossw.entity.User;
import fudan.ossw.service.FavoriteService;

import java.util.*;

/**
 * @ClassName FavoriteServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 21:47
 * @Version 1.0
 **/
public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = DaoFactory.getInstance().getFavoriteDao();
    String errorMessage = null;

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
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
    public List<Favorite> getFavorites(int userID) {
        return favoriteDao.getFavoriteList(userID);
    }

    @Override
    public List<Artwork> getRecentFavorite(int userID) {
        List<Favorite> recentFavorite = DaoFactory.getInstance().getFavoriteDao().getRecentFavorite(userID);
        List<Artwork> artworks = new LinkedList<>();
        for(Favorite favorite : recentFavorite) {
            artworks.add(DaoFactory.getInstance().getArtworkDao().getArtwork(favorite.getArtID()));
        }
        return artworks;
    }

    @Override
    public boolean addFavorite(int userID, int artworkID) {
        Favorite favorite = favoriteDao.getFavorite(userID, artworkID);
        if(favorite != null) {
            errorMessage = "您的收藏夹中已经存在该藏品";
            return false;
        }else {
            return favoriteDao.addFavorite(userID, artworkID);
        }
    }

    @Override
    public boolean deleteFavorite(int userID, int artworkID) {
        return favoriteDao.cancelFavorite(userID, artworkID);
    }

    @Override
    public boolean changeVisibility(int userID, int artworkID, boolean visible) {
        return favoriteDao.changeVisibility(userID, artworkID, visible);
    }

    @Override
    public List<Artwork> getRecommendArtworks(int userID) {
        List<Favorite> favorites = favoriteDao.getRecentFavorite(userID);
        List<Artwork> recommendArtworks = new ArrayList<>();
        if(favorites.size() == 0)
            return recommendArtworks;
        ArtworkDao artworkDao = DaoFactory.getInstance().getArtworkDao();
        Artwork recentFavorite = artworkDao.getArtwork(favorites.get(0).getArtID());
        String title = recentFavorite.getTitle();
        String location = recentFavorite.getLocation();
        List<Artwork> candidates = new ArrayList<>();
        CriteriaArtwork criteriaArtwork = new CriteriaArtwork();
        for(int i = 0; i < title.length(); i++) {
            criteriaArtwork.setTitle(title.charAt(i)+"");
            candidates.addAll(artworkDao.getCriteriaArtworks(criteriaArtwork, "view"));
        }
        criteriaArtwork.setTitle("");
        criteriaArtwork.setLocation(location);
        candidates.addAll(artworkDao.getCriteriaArtworks(criteriaArtwork, "view"));
        List<Integer> candidatesID = new ArrayList<>();
        for(Artwork artwork : candidates) {
            candidatesID.add(artwork.getArtID());
        }
        List<Integer> favoritesID = new ArrayList<>();
        for(Favorite favorite : favorites) {
            favoritesID.add(favorite.getArtID());
        }
        candidatesID.removeAll(favoritesID);
        Map<Integer, Integer> map = new TreeMap<>();
        for(int id : candidatesID) {
            if(map.containsKey(id)) {
                int num = map.get(id);
                map.put(id, num + 1);
            }else {
                map.put(id, 1);
            }
        }
        //按值排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<Integer,Integer> entry:list){
            recommendArtworks.add(artworkDao.getArtwork(entry.getKey()));
        }
        int length = 3;
        if(recommendArtworks.size() > length)
            return recommendArtworks.subList(recommendArtworks.size() - length, recommendArtworks.size());
        else
            return recommendArtworks;
    }
}
