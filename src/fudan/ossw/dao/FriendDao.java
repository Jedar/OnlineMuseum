package fudan.ossw.dao;

import fudan.ossw.entity.Friend;

import java.util.List;

public interface FriendDao {
    public boolean addFriend(Friend friend);

    public boolean updateFriend(int friendID, boolean visible);

    public boolean deleteFriend(int friendID);

    public List<Friend> getFriendList(int userAID);
}
