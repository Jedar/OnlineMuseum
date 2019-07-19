package fudan.ossw.dao.impl;

import entity.Friend;
import fudan.ossw.dao.FriendDao;

import java.util.List;

public class FriendDaoImpl implements FriendDao {
    @Override
    public boolean addFriend(int userAID, int userBID) {
        return false;
    }

    @Override
    public boolean deleteFriend(int userAID, int userBID) {
        return false;
    }

    @Override
    public List<Friend> getFriendList(int userAID) {
        return null;
    }
}
