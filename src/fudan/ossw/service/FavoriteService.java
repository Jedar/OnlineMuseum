package fudan.ossw.service;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.Favorite;

import java.util.List;

public interface FavoriteService extends BaseService {
    List<Artwork> getFavoriteList(int userID);
    List<Favorite> getFavorites(int userID);
    List<Artwork> getRecentFavorite(int userID);
    boolean deleteFavorite(int userID, int artworkID);
    boolean addFavorite(int userID, int artworkID);
    boolean changeVisibility(int userID, int artworkID, boolean visible);
    public List<Artwork> getRecommendArtworks(int userID);
}
