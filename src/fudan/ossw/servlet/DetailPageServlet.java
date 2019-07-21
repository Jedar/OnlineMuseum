package fudan.ossw.servlet;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
import fudan.ossw.entity.Artwork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailPageServlet", value = "/jsp/detail.jsp")
public class DetailPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        ArtworkDao artworkDao = new ArtworkDaoImpl();
//        String idStr = request.getParameter("id");
//        int id = 1;
//        if(idStr != null){
//            id = Integer.parseInt(idStr);
//        }
//        Artwork artwork = artworkDao.getArtwork(id);
        request.setAttribute("collection",artwork);

        request.getRequestDispatcher("./detail_page.jsp") .forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
