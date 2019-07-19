package fudan.ossw.dao.impl;

import fudan.ossw.dao.Dao;
import fudan.ossw.dao.NormalUserDao;
import fudan.ossw.entity.NormalUser;

public class NormalUserDaoImpl implements NormalUserDao {

    private Dao<NormalUser> dao = new JDBCDao<>();

    private static String SQL_SELECT_BY_ID = "SELECT userID, username, password, email, phone, address, isManager, visible, isDelete, lastLogin "
            + "FROM users WHERE userID=?";

    private static String SQL_SELECT_BY_NAME = "SELECT userID, username, password, email, phone, address, isManager, visible, isDelete, lastLogin "
            + "FROM users WHERE username=?";

    private static String SQL_UPDATE = "UPDATE users SET username=?, password=?,email=?,phone=?,address=?,isManager=?,visible=?,isDelete=?,lastLogin=? "
            + "WHERE userID=?";

    private static String SQL_INSERT = "INSERT INTO users VALUES (NULL,?,?,?,?,?,?,?,?)";

    @Override
    public NormalUser getUserByID(int id) {
        return dao.get(NormalUser.class, SQL_SELECT_BY_ID,id);
    }

    @Override
    public NormalUser getUserByName(String name) {
        return dao.get(NormalUser.class,SQL_SELECT_BY_NAME,name);
    }

    @Override
    public boolean deleteUser(int id) {
        NormalUser user = getUserByID(id);
        if(user == null){
            return false;
        }
        if(user.getIsDelete()){
            return false;
        }
        user.setIsDelete(true);
        dao.update(NormalUser.class,SQL_UPDATE,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete(),user.getLastLogin(),id);
        return true;
    }

    @Override
    public void addUser(NormalUser user) {
        dao.update(NormalUser.class,SQL_INSERT,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete());
    }

    @Override
    public void updateUser(int id, NormalUser user) {
        dao.update(NormalUser.class,SQL_UPDATE,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),
                user.getAddress(),user.getIsManager(),user.getVisible(),user.getIsDelete(),user.getLastLogin(),id);
    }
}
