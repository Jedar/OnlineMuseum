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

@WebServlet(name="ArtworkInfoServlet", value = "/jsp/artworkinfo.jsp")
public class ArtworkInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if ("change".equals(method)){
            fixArtworkPage(req);
        }
        else if ("upload".equals(method)){
            addArtworkPage(req);
        }
        else {
            /* 变更网页位置 */
        }

        req.getRequestDispatcher("./artworkinfo_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void addArtworkPage(HttpServletRequest req){
        req.setAttribute("whatToDo","upload_artwork");
        req.setAttribute("btnName","上传艺术品");
        req.setAttribute("imageFileName","");
        req.setAttribute("action","uploadArtwork.aws");
    }

    private void fixArtworkPage(HttpServletRequest req){
        ArtworkService service = new ArtworkServiceImpl();
        String artIDStr = req.getParameter("id");
        int artID = 0;
        try {
            artID = Integer.parseInt(artIDStr);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Artwork artwork = service.getArtworkByID(artID);

        req.setAttribute("artwork",artwork);

        req.setAttribute("whatToDo","change_artwork");
        req.setAttribute("btnName","提交修改");
        req.setAttribute("imageFileName","../img/"+artwork.getImageFileName());
        req.setAttribute("action","changeArtwork.aws");
    }
}
