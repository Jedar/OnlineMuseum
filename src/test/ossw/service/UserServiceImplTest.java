package test.ossw.service;

import fudan.ossw.entity.User;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.UserServiceImpl;

public class UserServiceImplTest {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();

        User user = new User(1,"name","password","asd");

        service.signup(user);

        System.out.println(service.getErrorMessage());

        user = new User(1,"admin","asd","adim@qq.com");

        service.signup(user);

        System.out.println(service.getErrorMessage());

        user = new User(1,"ser","asd","adim@qq.com");

        user = service.signup(user);

        System.out.println(service.getErrorMessage());

        user = new User(1,"serakfjhakdhakhd","asd","adim@qq.com");

        user = service.signup(user);

        System.out.println(service.getErrorMessage());

        user = new User(1,"test_service123","asd","adim@qq.com");

        user = service.signup(user);

        System.out.println(user == null);

        if (user != null) {
            service.delete(user.getUserID());
        }


    }
}
