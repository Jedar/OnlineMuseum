package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.Favorite;
import fudan.ossw.entity.User;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.FriendService;
import fudan.ossw.service.impl.ArtworkServiceImpl;
import fudan.ossw.service.impl.FavoriteServiceImpl;
import fudan.ossw.service.impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FavoritePageServlet",value = "/jsp/favorite.jsp")
public class FavoritePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*初始化收藏夹*/
        FavoriteService favoriteService = new FavoriteServiceImpl();
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        ArtworkService artworkService = new ArtworkServiceImpl();
        List<Favorite> favorites = favoriteService.getFavorites(userID);
        Map<Artwork, Favorite> favoriteVisibilityMap = new HashMap<>();
        for(Favorite favorite : favorites) {
            favoriteVisibilityMap.put(artworkService.getArtworkByID(favorite.getArtID()), favorite);
        }
        request.setAttribute("favoriteVisibilityMap", favoriteVisibilityMap);    /*用户的藏品信息及其收藏的时间可见性等*/
        request.getRequestDispatcher("./favorite_page.jsp").forward(request, response);
    }
}
