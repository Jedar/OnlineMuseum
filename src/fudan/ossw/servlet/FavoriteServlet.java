package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.ArtworkDao;
import fudan.ossw.dao.impl.ArtworkDaoImpl;
import fudan.ossw.entity.Artwork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FavoriteServlet",value = "/jsp/favor")
public class FavoriteServlet extends HttpServlet {
    private ArtworkDao artworkDao = new ArtworkDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        JSONObject json = new JSONObject();
        if("add".equals(action)){
            doAddCollection(request,response,json);
        }
        else if ("delete".equals(action)){
            doDeleteCollection(request,response,json);
        }
        else {
            json.put("success",false);
            response.getWriter().println(json.toJSONString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void doAddCollection(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if(idStr == null || idStr.equals("")){
            json.put("success",false);
            response.getWriter().println(json.toJSONString());
            return;
        }
        int id = Integer.parseInt(idStr);

        Artwork artwork = artworkDao.getArtwork(id);

        if(artwork == null){
            json.put("success",false);
            response.getWriter().println(json.toJSONString());
        }
        else{
            json.put("success",true);
            response.getWriter().println(json.toJSONString());
            List<Integer> wish = (List<Integer>)request.getSession().getAttribute("wish");
            wish.add(id);
        }
    }

    private void doDeleteCollection(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws ServletException, IOException {
        String indexStr = request.getParameter("index");
        if(indexStr == null || "".equals(indexStr)){
            json.put("success",false);
            response.getWriter().println(json.toJSONString());
            return;
        }
        List<Integer> wish = (List<Integer>)request.getSession().getAttribute("wish");
        int idx = Integer.parseInt(indexStr);
        if(idx >= wish.size()){
            json.put("success",false);
            response.getWriter().println(json.toJSONString());
            return;
        }
        wish.remove(idx);
        json.put("success",true);
        response.getWriter().println(json.toJSONString());
    }
}
