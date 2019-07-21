package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
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

@WebServlet(name = "FavoritePageServlet",value = "/jsp/favorite.jsp")
public class FavoritePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FavoriteService favoriteService = new FavoriteServiceImpl();
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        List<Artwork> favorite = favoriteService.getFavoriteList(userID);
        request.setAttribute("favorite", favorite);
        request.getRequestDispatcher("./favorite_page.jsp").forward(request, response);
    }
}
