package fudan.ossw.dao;

import fudan.ossw.entity.User;

public interface UserDao {

    public User getUserByID(int id);

    public User getUserByName(String name);

    public boolean deleteUser(int id);

    public void addUser(User user);

    public void updateUser(int id, User user);
}
