package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Friend;
import fudan.ossw.entity.Request;
import fudan.ossw.entity.User;
import fudan.ossw.service.FriendService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FriendServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 22:31
 * @Version 1.0
 **/
public class FriendServiceImpl implements FriendService {

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public List<User> getFriendsList(int userID) {
        List<Friend> friends = DaoFactory.getInstance().getFriendDao().getFriendList(userID);
        List<User> users = new ArrayList<>();
        for(Friend friend : friends) {
            users.add(DaoFactory.getInstance().getUserDao().getUserByID(friend.getPartyBID()));
        }
        return users;
    }

    @Override
    public List<Request> getRequestList(int userID) {
        return DaoFactory.getInstance().getRequestDao().getRequestList(userID);
    }

    @Override
    public boolean changePermission(int userID, int friendID, boolean permission) {
        Friend friend = DaoFactory.getInstance().getFriendDao().getFriend(userID, friendID);
        return DaoFactory.getInstance().getFriendDao().updateFriend(friend.getFriendID(), permission);
    }

    @Override
    public boolean deleteFriend(int userID, int friendID) {
        Friend friend1 = DaoFactory.getInstance().getFriendDao().getFriend(userID, friendID);
        Friend friend2 = DaoFactory.getInstance().getFriendDao().getFriend(friendID, userID);
        return DaoFactory.getInstance().getFriendDao().deleteFriend(friend1.getFriendID()) &&
                DaoFactory.getInstance().getFriendDao().deleteFriend(friend2.getFriendID());
    }

    @Override
    public boolean addFriend(int userID, int friendID) {
        Friend friend1 = new Friend(userID, friendID, true);
        Friend friend2 = new Friend(friendID, userID, true);
        return DaoFactory.getInstance().getFriendDao().addFriend(friend1) &&
                DaoFactory.getInstance().getFriendDao().addFriend(friend2);
    }

    @Override
    public boolean sendRequest(Request request) {
        return DaoFactory.getInstance().getRequestDao().addRequest(request);
    }

    @Override
    public void readRequest(int senderID, int receiverID, boolean agree) {
        DaoFactory.getInstance().getRequestDao().readRequest(senderID, receiverID, agree);
        if(agree) {
            addFriend(senderID, receiverID);
        }
    }
}
