package fudan.ossw.service.impl;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.dao.UserDao;
import fudan.ossw.entity.User;
import fudan.ossw.service.UserService;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private UserDao userDao = DaoFactory.getInstance().getUserDao();

    private String STR_ERROR = "用户名和密码错误";

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
        if (username == null || password == null){
            message = STR_ERROR;
            return null;
        }
        User user = userDao.getUserByName(username);
        if (user == null){
            message = STR_ERROR;
            return null;
        }
        if (!password.equals(user.getPassword())){
            message = STR_ERROR;
            return null;
        }
        user.setLastLogin(new Date(new java.util.Date().getTime()));
        userDao.updateUser(user.getUserID(),user);
        return user;
    }

    @Override
    public User signup(User user) {
        if (isWrongUser(user)){
            return null;
        }

        User check = userDao.getUserByName(user.getUsername());
        if (check != null){
            code = 17;
            message = "用户名重复";
            return null;
        }

        boolean flag = userDao.addUser(user);
        if (flag){
            return userDao.getUserByName(user.getUsername());
        }
        else{
            code = 18;
            message = "添加数据异常";
        }
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public User getUserByID(int userID) {
        return userDao.getUserByID(userID);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public boolean update(User user) {
        if (isWrongUser(user)){
            System.out.println("");
            return false;
        }
        return userDao.updateUser(user.getUserID(),user);
    }

    @Override
    public boolean delete(int userID) {
        return userDao.deleteUser(userID);
    }

    @Override
    public boolean insert(User user) {
        if (isWrongUser(user)){
            return false;
        }
        User check = userDao.getUserByName(user.getUsername());
        if (check != null){
            code = 17;
            message = "用户名重复";
            return false;
        }

        boolean flag = userDao.addUser(user);
        if (flag){
            return true;
        }
        else{
            code = 18;
            message = "添加数据异常";
        }
        return false;
    }

    private boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        return m.matches();
    }

    private boolean isWrongUser(User user){
        if (user == null){
            code = 10;
            message = "注册异常";
            return true;
        }
        if ("".equals(user.getUsername()) || user.getUsername() == null){
            code = 11;
            message = "用户名为空";
            return true;
        }
        if ("".equals(user.getPassword()) || user.getPassword() == null){
            code = 12;
            message = "密码为空";
            return true;
        }
        if ("".equals(user.getEmail()) || user.getEmail() == null){
            code = 13;
            message = "邮箱为空";
            return true;
        }

        int nameLen = user.getUsername().length();
        if (nameLen < 4 || nameLen > 15){
            code = 14;
            message = "用户名格式错误";
            return true;
        }

        if (!isEmail(user.getEmail())){
            code = 16;
            message = "邮箱格式错误";
            return true;
        }
        return false;
    }

    @Override
    public User getUser(int userID) {
        return userDao.getUserByID(userID);
    }

}
