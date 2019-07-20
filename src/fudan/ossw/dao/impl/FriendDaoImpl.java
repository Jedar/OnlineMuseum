package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.FriendDao;
import fudan.ossw.entity.Friend;

import java.util.List;

public class FriendDaoImpl implements FriendDao {
    private BaseDao<Friend> dao = new JDBCDao<>();

    @Override
    public boolean addFriend(Friend friend) {
        String sql = "INSERT INTO `OnlineMuseum`.`friends`\n" +
                "(`friendID`,\n" +
                "`partyAID`,\n" +
                "`partyBID`,\n" +
                "`favoritesVisible`)\n" +
                "VALUES\n" +
                "(NULL,?,?,?);\n";
        return dao.update(Friend.class,sql,friend.getPartyAID(),friend.getPartyBID(),friend.getFavoritesVisible());
    }

    @Override
    public boolean updateFriend(int friendID, boolean visible) {
        String sql = "UPDATE `OnlineMuseum`.`friends`\n" +
                "SET\n" +
                "`favoritesVisible` = ?\n" +
                "WHERE `friendID` = ?;\n";
        return dao.update(Friend.class,sql,visible,friendID);
    }

    @Override
    public boolean deleteFriend(int friendID) {
        String sql = "DELETE FROM `OnlineMuseum`.`friends` WHERE friendID=?;";
        return dao.update(Friend.class,sql,friendID);
    }

    @Override
    public List<Friend> getFriendList(int userAID) {
        String sql = "SELECT `friends`.`friendID`,\n" +
                "    `friends`.`partyAID`,\n" +
                "    `friends`.`partyBID`,\n" +
                "    `friends`.`favoritesVisible`\n" +
                "FROM `OnlineMuseum`.`friends`\n" +
                "WHERE `partyAID`=?;";
        return dao.getForList(Friend.class,sql,userAID);
    }

    @Override
    public Friend getFriend(int partyAID, int partyBID) {
        String sql = "SELECT * FROM friends WHERE partyAID = ? AND partyBID = ?";
        return dao.get(Friend.class, sql, partyAID, partyBID);
    }
}
