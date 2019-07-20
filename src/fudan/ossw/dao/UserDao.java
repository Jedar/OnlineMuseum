package fudan.ossw.dao;

import fudan.ossw.entity.CriteriaUser;
import fudan.ossw.entity.User;

import java.util.List;

public interface UserDao {

    public User getUserByID(int id);

    public User getUserByName(String name);

    public boolean deleteUser(int id);

    public boolean addUser(User user);

    public boolean updateUser(int id, User user);

    public List<User> getCriteriaUsers(CriteriaUser cu);
}
