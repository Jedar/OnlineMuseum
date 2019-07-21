package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
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
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "ArtworkServlet", value = "*.aws")
public class ArtworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 4);
        try {
            /*利用反射得到对应的方法*/
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*调用方法*/
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        int pageIndex = ((mark-1) * 6);

        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        ArtworkService artworkService = new ArtworkServiceImpl();
        List<Artwork> artworks = artworkService.searchPage(title, description, location, sortWay, pageIndex, pageSize);

        JSONObject object = new JSONObject();
        object.put("success",true);
        object.put("index",mark);
        object.put("artworkList",artworks);

        try {
            response.getWriter().println(object.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void artworkDetail(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
