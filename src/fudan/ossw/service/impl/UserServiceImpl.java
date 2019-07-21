package fudan.ossw.service.impl;

import fudan.ossw.entity.User;
import fudan.ossw.service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/20 19:21
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private String message;

    private int code;

    @Override
    public int getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User signup(User user) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int userID) {
        return false;
    }
}
