package fudan.ossw.service;
import fudan.ossw.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 15:52
 * @Version 1.0
 **/
public interface UserService extends BaseService {
    User login(String username, String password);
    User getUser(int userID);
    User signup(User user);
    User getUserByID(int userID);
    User getUserByName(String username);
    List<User> getAllUser();
    boolean update(User user);
    boolean delete(int userID);
    boolean insert(User user);
}
