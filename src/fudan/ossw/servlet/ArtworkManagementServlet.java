package fudan.ossw.servlet;

import fudan.ossw.entity.Artwork;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArtworkManagementServlet", value = "/jsp/artworkmanagement.jsp")
public class ArtworkManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        ArtworkService service = new ArtworkServiceImpl();

        List<Artwork> artworks = service.search("","","","view");

        request.setAttribute("artworkList",artworks);

        request.getRequestDispatcher("./artworkmanagement_page.jsp").forward(request,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
