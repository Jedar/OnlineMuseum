package fudan.ossw.dao;

import java.util.List;

public interface FriendDao {
    public boolean addFriend(int userAID, int userBID);

    public boolean deleteFriend(int userAID, int userBID);

    public List<entity.Friend> getFriendList(int userAID);
}
