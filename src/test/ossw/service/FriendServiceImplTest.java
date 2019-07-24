package test.ossw.service;

import fudan.ossw.service.FriendService;
import fudan.ossw.service.impl.FriendServiceImpl;

/**
 * @ClassName FriendServiceImplTest
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/24 15:27
 * @Version 1.0
 **/
public class FriendServiceImplTest {
    public static void main(String[] args) {
        FriendService friendService = new FriendServiceImpl();
        System.out.println(friendService.getRecommendFriends(1));
    }
}
