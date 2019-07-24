package fudan.ossw.service;
import fudan.ossw.entity.Request;
import fudan.ossw.entity.User;

import java.util.List;

/**
 * @ClassName FriendService
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 16:20
 * @Version 1.0
 **/
public interface FriendService extends BaseService {
    /*得到好友列表*/
    List<User> getFriendsList(int userID);

    /*得到好友申请信息列表*/
    List<Request> getRequestList(int userID);

    /*更改好友权限*/
    boolean changePermission(int userID, int friendID, boolean permission);

    /*删除好友*/
    boolean deleteFriend(int userID, int friendID);

    /*添加好友*/
    boolean addFriend(int userID, int friendID);

    /*发送好友请求*/
    boolean sendRequest(Request request);

    /*阅读好友请求*/
    boolean readRequest(int requestID, boolean agree);

    /*得到推荐好友列表*/
    List<User> getRecommendFriends(int userID);
}
