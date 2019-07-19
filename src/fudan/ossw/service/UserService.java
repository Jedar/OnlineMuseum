package service;

import fudan.ossw.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/19 15:52
 * @Version 1.0
 **/
public interface UserService {
    String getErrorMessage();
    User login(String username, String password);
    User signup(List<String> msgs);
    boolean update(User user);
    boolean delete(User user);
}
