package fudan.ossw.servlet;

import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Artwork;
import fudan.ossw.entity.CriteriaArtwork;
import fudan.ossw.service.ArtworkService;
import fudan.ossw.service.impl.ArtworkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArtworkServlet", value = "*.aws")
public class ArtworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void uploadArtwork(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteArtwork(HttpServletRequest request, HttpServletResponse response) {

    }

    private void changeArtwork(HttpServletRequest request, HttpServletResponse response) {

    }

    private void searchArtwork(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String description  = request.getParameter("description");
        String location = request.getParameter("location");
        String sortWay = request.getParameter("sortWay");
        int mark = Integer.parseInt(request.getParameter("mark"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        ArtworkService artworkService = new ArtworkServiceImpl();
        List<Artwork> artworks = artworkService.searchPage(title, description, location, sortWay, mark, pageSize);
    }

    private void artworkDetail(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
