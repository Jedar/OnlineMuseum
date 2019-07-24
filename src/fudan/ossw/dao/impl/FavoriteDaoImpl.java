package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.FavoriteDao;
import fudan.ossw.entity.Favorite;
import java.sql.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private BaseDao<Favorite> dao = new JDBCDao<>();

    @Override
    public Favorite getFavorite(int userID, int artworkID) {
        String sql = "SELECT * FROM favorites WHERE userID = ? AND artID = ?";
        return dao.get(Favorite.class, sql, userID, artworkID);
    }

    @Override
    public List<Favorite> getFavoriteList(int userID) {
        String sql = "SELECT * FROM favorites WHERE userID = ?";
        List<Favorite> list = null;
        list = dao.getForList(Favorite.class,sql,userID);
        return list;
    }

    @Override
    public List<Favorite> getRecentFavorite(int userID) {
        String sql = "SELECT * FROM favorites WHERE userID = ? AND visible = ? ORDER BY ? LIMIT ?, ?";
        return dao.getForList(Favorite.class,sql,userID, true, "addTime", 0, 5);
    }

    @Override
    public List<Favorite> getWhoFavorite(int artworkID) {
        String sql = "SELECT * FROM favorites WHERE artID = ?";
        List<Favorite> list = null;
        list = dao.getForList(Favorite.class,sql,artworkID);
        return list;
    }

    @Override
    public boolean addFavorite(int userID, int artworkID) {
        String sql = "INSERT INTO `OnlineMuseum`.`favorites`\n" +
                "(`favoriteID`,\n" +
                "`userID`,\n" +
                "`artID`,\n" +
                "`addTime`,\n" +
                "`visible`)\n" +
                "VALUES\n" +
                "(NULL,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?);\n";
        return dao.update(Favorite.class,sql,userID,artworkID,new Date(new java.util.Date().getTime()), true);
    }

    @Override
    public boolean cancelFavorite(int userID, int artworkID) {
        String sql = "DELETE FROM `OnlineMuseum`.`favorites` WHERE userID=? AND artID=?;";
        return dao.update(Favorite.class,sql,userID,artworkID);
    }

    @Override
    public int getFavoriteCount(int userID) {
        return getFavoriteList(userID).size();
    }

    @Override
    public boolean changeVisibility(int userID, int artworkID, boolean visible) {
        String sql = "UPDATE favorites SET visible = ? WHERE userID = ? AND artID = ?";
        return dao.update(Favorite.class, sql, visible, userID, artworkID);
    }
}
