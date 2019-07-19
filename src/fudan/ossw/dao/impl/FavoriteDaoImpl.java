package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.entity.Favorite;

import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private BaseDao<Favorite> dao = new JDBCDao<>();

    @Override
    public List<Favorite> getFavoriteList(int userID) {
        String sql = "SELECT `favorites`.`favoriteID`,\n" +
                "    `favorites`.`userID`,\n" +
                "    `favorites`.`artID`\n" +
                "FROM `OnlineMuseum`.`favorites`;\n" +
                "WHERE userID=?;";

        List<Favorite> list = null;
        list = dao.getForList(Favorite.class,sql,userID);
        return list;
    }

    @Override
    public List<Favorite> getWhoFavorite(int artworkID) {
        String sql = "SELECT `favorites`.`favoriteID`,\n" +
                "    `favorites`.`userID`,\n" +
                "    `favorites`.`artID`\n" +
                "FROM `OnlineMuseum`.`favorites`;\n" +
                "WHERE artID=?;";

        List<Favorite> list = null;
        list = dao.getForList(Favorite.class,sql,artworkID);
        return list;
    }

    @Override
    public boolean addFavorite(int userID, int artworkID) {
        String sql = "INSERT INTO `OnlineMuseum`.`favorites`\n" +
                "(`favoriteID`,\n" +
                "`userID`,\n" +
                "`artID`)\n" +
                "VALUES\n" +
                "(NULL,?,?);\n";
        return dao.update(Favorite.class,sql,userID,artworkID);
    }

    @Override
    public void cancelFavorite(int userID, int artworkID) {
        String sql = "DELETE FROM Person WHERE LastName = 'Wilson' ";
    }

    @Override
    public int getFavoriteCount(int userID) {
        return 0;
    }
}
