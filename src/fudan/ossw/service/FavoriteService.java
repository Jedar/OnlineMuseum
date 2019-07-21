package fudan.ossw.service;
import fudan.ossw.entity.Artwork;

import java.util.List;

public interface FavoriteService extends BaseService {
    List<Artwork> getFavoriteList(int userID);
    List<Artwork> getRecentFavorite(int userID);
    boolean deleteFavorite(int userID, int artworkID);
    boolean addFavorite(int userID, int artworkID);
}
