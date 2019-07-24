package fudan.ossw.servlet;

import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.User;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.FriendService;
import fudan.ossw.service.impl.FavoriteServiceImpl;
import fudan.ossw.service.impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfilePageServlet", value = "/jsp/profile.jsp")
public class ProfilePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*初始化profile页面*/
        request.setAttribute("navItemPerson","active");
        FriendService friendService = new FriendServiceImpl();
        FavoriteService favoriteService = new FavoriteServiceImpl();
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        List<User> friends = friendService.getFriendsList(userID);
        List<Artwork> favorite = favoriteService.getFavoriteList(userID);
        request.setAttribute("friends", friends);  /*好友信息*/
        request.setAttribute("favorite", favorite); /*收藏夹信息*/
        request.getRequestDispatcher("./profile_page.jsp").forward(request, response);
    }
}
