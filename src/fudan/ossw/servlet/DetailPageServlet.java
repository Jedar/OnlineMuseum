package fudan.ossw.servlet;

import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
import fudan.ossw.entity.Artwork;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

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
        ArtworkService service = new ArtworkServiceImpl();

//        ArtworkDao artworkDao = new ArtworkDaoImpl();
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

        Artwork artwork = service.getArtworkByID(id);
        request.setAttribute("collection",artwork);

        System.out.println(id);
        request.getRequestDispatcher("./detail_page.jsp").forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
