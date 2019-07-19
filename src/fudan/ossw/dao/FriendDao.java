package fudan.ossw.dao;

import fudan.ossw.entity.Friend;

import java.util.List;

public interface FriendDao {
    public boolean addFriend(int userAID, int userBID);

    public boolean deleteFriend(int userAID, int userBID);

    public List<Friend> getFriendList(int userAID);
}
