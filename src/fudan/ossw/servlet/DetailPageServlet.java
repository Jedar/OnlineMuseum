package fudan.ossw.servlet;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
import fudan.ossw.data.ScopeKey;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.User;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DetailPageServlet", value = "/jsp/detail.jsp")
public class DetailPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        /* 暂存用户访问的页面，用于登陆后的页面返回 */
        request.getSession().setAttribute(ScopeKey.blockPage,request.getServletPath());


        ArtworkService service = new ArtworkServiceImpl();
        String idStr = request.getParameter("id");
        int id = 1;
        if(idStr != null){
            try{
                id = Integer.parseInt(idStr);
                /* view count++ */
                service.view(id);
            }
            catch (Exception e){
                id = 1;
            }
        }

        /* 详情页面艺术品的信息 */
        Artwork artwork = service.getArtworkByID(id);
        request.setAttribute("collection",artwork);

        /* 控制管理艺术品按钮 */
        String manageStr = "invisible";
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            manageStr = "invisible";
        }
        else if (user.getIsManager()){
            manageStr = "";
        }

        /* 控制推荐艺术品栏的呈现 */
        List<Artwork> recommendArtworks = new ArrayList<>();
        String recommendNav = "invisible";
        if (user != null){
            recommendNav = "";
            recommendArtworks = service.getRecommendArtworks(user.getUserID());
        }

        request.setAttribute("navItemDetail","active");
        request.setAttribute("recommendArtworks",recommendArtworks);

        System.out.println(request.getAttribute("recommendArtworks"));

        request.setAttribute("recommendNav",recommendNav);
        request.setAttribute("manageStr",manageStr);
        request.getRequestDispatcher("./detail_page.jsp").forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
