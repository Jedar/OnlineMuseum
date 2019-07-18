package fudan.ossw.dao;

import fudan.ossw.entity.NormalUser;

public interface NormalUserDao {

    public NormalUser getUserByID(int id);

    public NormalUser getUserByName(String name);

    public boolean deleteUser(int id);

    public void addUser(NormalUser user);

    public void updateUser(int id, NormalUser user);
}
