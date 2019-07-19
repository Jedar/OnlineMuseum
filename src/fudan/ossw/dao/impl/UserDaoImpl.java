package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.UserDao;
import fudan.ossw.entity.User;

public class UserDaoImpl implements UserDao {

    private BaseDao<User> baseDao = new JDBCDao<>();

    private static String SQL_SELECT_BY_ID = "SELECT userID, username, password, email, phone, address, isManager, visible, isDelete, lastLogin "
            + "FROM users WHERE userID=?";

    private static String SQL_SELECT_BY_NAME = "SELECT userID, username, password, email, phone, address, isManager, visible, isDelete, lastLogin "
            + "FROM users WHERE username=?";

    private static String SQL_UPDATE = "UPDATE users SET username=?, password=?,email=?,phone=?,address=?,isManager=?,visible=?,isDelete=?,lastLogin=? "
            + "WHERE userID=?";

    private static String SQL_INSERT = "INSERT INTO users VALUES (NULL,?,?,?,?,?,?,?,?)";

    @Override
    public User getUserByID(int id) {
        return baseDao.get(User.class, SQL_SELECT_BY_ID,id);
    }

    @Override
    public User getUserByName(String name) {
        return baseDao.get(User.class,SQL_SELECT_BY_NAME,name);
    }

    @Override
    public boolean deleteUser(int id) {
        User user = getUserByID(id);
        if(user == null){
            return false;
        }
        if(user.getIsDelete()){
            return false;
        }
        user.setIsDelete(true);
        return baseDao.update(User.class,SQL_UPDATE,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete(),user.getLastLogin(),id);
    }

    @Override
    public boolean addUser(User user) {
        return baseDao.update(User.class,SQL_INSERT,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete());
    }

    @Override
    public boolean updateUser(int id, User user) {
        return baseDao.update(User.class,SQL_UPDATE,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete(),user.getLastLogin(),id);
    }
}
