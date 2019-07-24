package test.ossw.service;

import fudan.ossw.entity.Favorite;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.impl.FavoriteServiceImpl;

/**
 * @ClassName FavoriteServiceImplTest
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/24 21:22
 * @Version 1.0
 **/
public class FavoriteServiceImplTest {
    public static void main(String[] args) {
        FavoriteService favoriteService = new FavoriteServiceImpl();
        System.out.println(favoriteService.getRecommendArtworks(1));
    }
}
