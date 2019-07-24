package fudan.ossw.service;
import fudan.ossw.entity.CriteriaUser;
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
    /*用户登陆*/
    User login(String username, String password);

    /*通过ID来得到一个用户*/
    User getUser(int userID);

    /*用户注册*/
    User signup(User user);

    /*通过ID来得到一个用户*/
    User getUserByID(int userID);

    /*通过用户名来得到一个用户*/
    User getUserByName(String username);

    /*得到所有的用户*/
    List<User> getAllUser();

    /*更新用户信息*/
    boolean update(User user);

    /*删除用户*/
    boolean delete(int userID);

    /*添加用户*/
    boolean insert(User user);

    /*通过用户名来对用户进行模糊搜索*/
    List<User> getCriteriaUsers(String username);
}
