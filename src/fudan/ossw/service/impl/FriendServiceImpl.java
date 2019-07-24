package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.dao.FriendDao;
import fudan.ossw.dao.RequestDao;
import fudan.ossw.entity.Friend;
import fudan.ossw.entity.Request;
import fudan.ossw.entity.User;
import fudan.ossw.service.FriendService;

import java.util.*;

/**
 * @ClassName FriendServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 22:31
 * @Version 1.0
 **/
public class FriendServiceImpl implements FriendService {
    private FriendDao friendDao = DaoFactory.getInstance().getFriendDao();

    String errorMessage = "";
    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public List<User> getFriendsList(int userID) {
        List<Friend> friends = friendDao.getFriendList(userID);
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
        if(friend1 == null || friend2 == null){
            return false;
        }
        return friendDao.deleteFriend(friend1.getFriendID()) &&
                friendDao.deleteFriend(friend2.getFriendID());
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
        RequestDao requestDao = DaoFactory.getInstance().getRequestDao();
        //检测重复发送
        if(requestDao.getRequestList(request.getSenderID(), request.getReceiverID()).size() > 0) {
            errorMessage = "已发送过申请信息";
            return false;
        }
        //检测是否已经接收到对方的好友申请且处于未读状态
        if(requestDao.getRequestList(request.getReceiverID(), request.getSenderID()).size() > 0) {
            errorMessage = "您有未读的来自该用户的好友申请";
            return false;
        }
        if (DaoFactory.getInstance().getRequestDao().addRequest(request)) {
            return true;
        }
        errorMessage = "数据库出错，请重新发送";
        return false;
    }

    @Override
    public boolean readRequest(int requestID, boolean agree) {
        DaoFactory.getInstance().getRequestDao().readRequest(requestID, agree);
        if(agree) {
            Request request = DaoFactory.getInstance().getRequestDao().getRequest(requestID);
           return addFriend(request.getSenderID(), request.getReceiverID());
        }
        return true;
    }

    @Override
    public List<User> getRecommendFriends(int userID) {
        List<User> myFriends = getFriendsList(userID);
        List<User> candidates = new ArrayList<>();
        for(User user : myFriends) {
            candidates.addAll(getFriendsList(user.getUserID()));
        }
        List<Integer> myFriendsID = new ArrayList<>();
        for(User user : myFriends) {
            myFriendsID.add(user.getUserID());
        }
        List<Integer> candidatesID = new ArrayList<>();
        for(User user : candidates) {
            candidatesID.add(user.getUserID());
        }
        candidatesID.removeAll(myFriendsID);
        Map<Integer, Integer> map = new TreeMap<>();
        for(int id : candidatesID) {
            if(map.containsKey(id)) {
                int num = map.get(id);
                map.put(id, num + 1);
            }else {
                map.put(id, 1);
            }
        }
        //按值排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        //去除自身
        map.remove(userID);
        List<User> recommendFriends = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            recommendFriends.add(DaoFactory.getInstance().getUserDao().getUserByID(integer));
        }
        if(recommendFriends.size() > 3)
            return recommendFriends.subList(0, 2);
        else
            return recommendFriends;
    }
}
