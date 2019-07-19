package test.ossw.dao;

import fudan.ossw.dao.FriendDao;
import fudan.ossw.dao.impl.FriendDaoImpl;
import fudan.ossw.entity.Friend;

import java.util.List;

public class FriendDaoImplTest {
    public static void main(String[] args) {
        FriendDao dao = new FriendDaoImpl();

        List<Friend> list;

        list = dao.getFriendList(1);

        int num = list.size();

        Friend friend = new Friend(1,2,false);

        dao.addFriend(friend);

        list = dao.getFriendList(1);

        System.out.println(list.size() == num + 1);

        dao.deleteFriend(list.get(0).getFriendID());

        list = dao.getFriendList(1);

        System.out.println(list.size() == num);
    }
}
