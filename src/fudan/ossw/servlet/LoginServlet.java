package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.UserDao;
import fudan.ossw.dao.impl.UserDaoImpl;
import fudan.ossw.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet",value = "/jsp/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        JSONObject json = new JSONObject();
        if("".equals(name) || name == null){
            json.put("success",false);
            json.put("message","You must enter name");
            response.getWriter().println(json.toJSONString());
            return;
        }
        if("".equals(pwd) || pwd == null){
            json.put("success",false);
            json.put("message","You must enter password");
            response.getWriter().println(json.toJSONString());
            return;
        }
        name = name.trim();
        pwd = pwd.trim();

        User user = userDao.getUserByName(name);

        if(user != null){

            if(pwd.equals(user.getPassword())){
                json.put("success",true);
                response.getWriter().println(json.toJSONString());
                System.out.println("Success");
                HttpSession session = request.getSession();
                session.setAttribute("wish",new ArrayList<Integer>());
                session.setAttribute("username",name);
                session.setAttribute("isLogin",true);
            }
            else{
                json.put("success",false);
                json.put("message","Error:Wrong Password");
                response.getWriter().println(json.toJSONString());
            }
        }
        else{
            json.put("success",false);
            json.put("message","Error:User name not exist");
            response.getWriter().println(json.toJSONString());
            response.getWriter().println();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
