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
public interface FriendService {
    String getErrorMessage();
    List<User> getFriendsList(int userID);
    List<Request> getRequestList(int userID);
    boolean changePermission(int userID, int friendID, boolean permission);
    boolean deleteFriend(int userID, int friendID);
    boolean addFriend(int userID, int friendID);
    boolean sendRequest(Request request);
    void agreeRequest(int requestID);
    void refuseRequest(int requestID);
}
