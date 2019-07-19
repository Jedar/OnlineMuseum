package test.ossw.dao;

import fudan.ossw.dao.UserDao;
import fudan.ossw.dao.impl.UserDaoImpl;
import fudan.ossw.entity.User;

public class UserDaoImplTest {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();

        boolean flag;

        String name = "hello_";

        User user = new User(1,name,"pop","mike@gmail.com","18761853654","China");

        flag = dao.addUser(user);

        System.out.println(flag);

        User temp = dao.getUserByName(name);

        System.out.println(temp.getSignature());

        temp.setSignature("blabla");

        dao.updateUser(temp.getUserID(),temp);

        temp = dao.getUserByName(name);

        System.out.println(temp.getSignature());
    }
}
