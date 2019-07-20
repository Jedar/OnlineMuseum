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
    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User signup(List<String> msgs) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
