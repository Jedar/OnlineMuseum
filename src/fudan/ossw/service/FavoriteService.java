package fudan.ossw.service;
import fudan.ossw.entity.Artwork;

import java.util.List;

public interface FavoriteService {
    String getErrorMessage();
    List<Artwork> getFavoriteList(int userID);
    boolean deleteFavorite(int userID, int artworkID);
}
