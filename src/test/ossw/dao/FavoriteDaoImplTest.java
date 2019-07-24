package test.ossw.dao;

import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.dao.impl.FavoriteDaoImpl;
import fudan.ossw.entity.Favorite;

import java.util.List;

public class FavoriteDaoImplTest {
    public static void main(String[] args) {
        FavoriteDao dao = new FavoriteDaoImpl();

        dao.addFavorite(2,3);

        List<Favorite> list = dao.getFavoriteList(2);

        System.out.println(list.size() == 1);

        dao.cancelFavorite(2,3);

        list = dao.getFavoriteList(2);

        System.out.println(list.size() == 0);
        System.out.println();
    }
}
