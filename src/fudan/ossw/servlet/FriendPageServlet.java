package fudan.ossw.servlet;

import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.Favorite;
import fudan.ossw.entity.User;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.FavoriteServiceImpl;
import fudan.ossw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FriendPageServlet", value = "/jsp/friend.jsp")
public class FriendPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int friendID = 1;
        if(idStr != null){
            try{
                friendID = Integer.parseInt(idStr);
            }
            catch (Exception e){
                friendID = 1;
            }
        }
        UserService userService = new UserServiceImpl();
        User friend = userService.getUser(friendID);
        FavoriteService favoriteService = new FavoriteServiceImpl();
        List<Artwork> recentFavorite = favoriteService.getRecentFavorite(friendID);
        request.setAttribute("friend", friend);
        request.setAttribute("recentFavorite",recentFavorite);
        request.getRequestDispatcher("./friend_page.jsp").forward(request,response);
    }
}
