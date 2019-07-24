package fudan.ossw.service;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.Favorite;

import java.util.List;

public interface FavoriteService extends BaseService {
    /*得到收藏夹中的艺术品列表*/
    List<Artwork> getFavoriteList(int userID);

    /*得到收藏夹中的收藏列表*/
    List<Favorite> getFavorites(int userID);

    /*得到最近收藏的公开艺术品*/
    List<Artwork> getRecentFavorite(int userID);

    /*取消收藏*/
    boolean deleteFavorite(int userID, int artworkID);

    /*添加收藏*/
    boolean addFavorite(int userID, int artworkID);

    /*改变藏品的可见性*/
    boolean changeVisibility(int userID, int artworkID, boolean visible);

    /*得到推荐艺术品*/
    public List<Artwork> getRecommendArtworks(int userID);
}
