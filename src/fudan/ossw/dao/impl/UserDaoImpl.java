package fudan.ossw.dao.impl;

import fudan.ossw.dao.BaseDao;
import fudan.ossw.dao.UserDao;
import fudan.ossw.entity.User;

public class UserDaoImpl implements UserDao {

    private BaseDao<User> baseDao = new JDBCDao<>();

    @Override
    public User getUserByID(int id) {
        String SQL_SELECT_BY_ID = "SELECT `users`.`userID`,\n" +
                "    `users`.`username`,\n" +
                "    `users`.`password`,\n" +
                "    `users`.`email`,\n" +
                "    `users`.`phone`,\n" +
                "    `users`.`address`,\n" +
                "    `users`.`isManager`,\n" +
                "    `users`.`visible`,\n" +
                "    `users`.`isDelete`,\n" +
                "    `users`.`lastLogin`,\n" +
                "    `users`.`signature`\n" +
                "FROM `OnlineMuseum`.`users`\n" +
                "WHERE userID=?";
        return baseDao.get(User.class, SQL_SELECT_BY_ID,id);
    }

    @Override
    public User getUserByName(String name) {
        String SQL_SELECT_BY_NAME = "SELECT `users`.`userID`,\n" +
                "    `users`.`username`,\n" +
                "    `users`.`password`,\n" +
                "    `users`.`email`,\n" +
                "    `users`.`phone`,\n" +
                "    `users`.`address`,\n" +
                "    `users`.`isManager`,\n" +
                "    `users`.`visible`,\n" +
                "    `users`.`isDelete`,\n" +
                "    `users`.`lastLogin`,\n" +
                "    `users`.`signature`\n" +
                "FROM `OnlineMuseum`.`users`\n" +
                "WHERE `username`=?";
        return baseDao.get(User.class, SQL_SELECT_BY_NAME,name);
    }

    @Override
    public boolean deleteUser(int id) {
        String sql = "UPDATE `OnlineMuseum`.`users`\n" +
                "SET\n" +
                "`isDelete` = ?,\n" +
                "WHERE `userID` = ?;\n";
        User user = getUserByID(id);
        if(user == null){
            return false;
        }
        if(user.getIsDelete()){
            return false;
        }
        user.setIsDelete(true);
        return baseDao.update(User.class,sql,false,id);
    }

    @Override
    public boolean addUser(User user) {
        String SQL_INSERT = "INSERT INTO `OnlineMuseum`.`users`\n" +
                "(`userID`,\n" +
                "`username`,\n" +
                "`password`,\n" +
                "`email`,\n" +
                "`phone`,\n" +
                "`address`,\n" +
                "`isManager`,\n" +
                "`visible`,\n" +
                "`isDelete`,\n" +
                "`lastLogin`,\n" +
                "`signature`)\n" +
                "VALUES\n" +
                "(NULL,?,?,?,?,?,?,?,?,?,?);\n";
        return baseDao.update(User.class, SQL_INSERT,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getIsManager(),
                user.getVisible(),
                user.getIsDelete(),
                user.getLastLogin(),
                user.getSignature());
    }

    @Override
    public boolean updateUser(int id, User user) {
        String SQL_UPDATE = "UPDATE `OnlineMuseum`.`users`\n" +
                "SET\n" +
                "`username` = ?,\n" +
                "`password` = ?,\n" +
                "`email` = ?,\n" +
                "`phone` = ?,\n" +
                "`address` = ?,\n" +
                "`isManager` = ?,\n" +
                "`visible` = ?,\n" +
                "`isDelete` = ?,\n" +
                "`lastLogin` = ?,\n" +
                "`signature` = ?\n" +
                "WHERE `userID` = ?;\n";
        return baseDao.update(User.class, SQL_UPDATE,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getIsManager(),
                user.getVisible(),
                user.getIsDelete(),
                user.getLastLogin(),
                user.getSignature(),
                id);
    }
}
