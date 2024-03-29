package fudan.ossw.servlet;

import fudan.ossw.data.ScopeKey;
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
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "SearchPageServlet", value = "/jsp/search.jsp")
public class SearchPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("navItemSearch","active");

        /* 暂存用户访问的页面，用于登陆后的页面返回 */
        req.getSession().setAttribute(ScopeKey.blockPage,req.getServletPath());

        String title;
        String description;
        String location;
        String sort;

        title = (String)req.getParameter("title");
        description = (String)req.getParameter("description");
        location = (String)req.getParameter("location");
        sort = (String)req.getParameter("sort");

        /* 防止搜索条件为空 */
        if (title == null){
            title = "";
        }
        if (description == null){
            description = "";
        }
        if (location == null){
            location = "";
        }
        if (sort == null){
            sort = "view";
        }

        /* 转换编码 */
        title = new String(title.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        description = new String(description.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        location = new String(location.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);


        /* 搜索业务 */
        ArtworkService service = new ArtworkServiceImpl();

        List<Artwork> list = service.search(title,description,location,sort);

        /*  计算页面下标*/
        int totalNumber = list.size();

        list = service.searchPage(title,description,location,sort,0,6);

        req.setAttribute("artworkList",list);

        int pageNumber = totalNumber%6==0?totalNumber/6:totalNumber/6+1;

        req.setAttribute("totalNumber",pageNumber);

        if ("view".equals(sort)){
            req.setAttribute("option1","selected");
        }
        else if ("timeReleased".equals(sort)){
            req.setAttribute("option2","selected");
        }

        req.getRequestDispatcher("./search_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
