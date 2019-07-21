package fudan.ossw.servlet;

import fudan.ossw.entity.Artwork;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageServlet",value = "/jsp/home.jsp")
public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtworkService service = new ArtworkServiceImpl();

        List<Artwork> heat = service.getHeatList();

        List<Artwork> newest = service.getNewestList();

        for (int i = 0; i < heat.size(); i++){
            req.setAttribute("heat"+i,heat.get(i));
        }

        for (int i = 0; i < newest.size(); i++){
            req.setAttribute("newest"+i,newest.get(i));
        }

        req.getRequestDispatcher("./home_page.jsp") .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
