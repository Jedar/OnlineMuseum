package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.User;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.FavoriteServiceImpl;
import fudan.ossw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserServlet", value = "*.us")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private JSONObject json = new JSONObject();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(5, servletPath.length() - 3);
        try {
            /*利用反射得到对应的方法*/
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*调用方法*/
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /*用户登陆*/
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        User user = userService.login(name, pwd);
        if(user == null) {
            json.put("success", false);
            json.put("message", userService.getErrorMessage());
            response.getWriter().println(json);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }
    }

    /*用户登出*/
    private void logout(HttpServletRequest request, HttpServletResponse response) {

    }

    /*用户注册*/
    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
//        List<String> msg = Arrays.asList(name, pwd, address, phone, email);
        User user = new User(-1,name,pwd,email);
        user = userService.signup(user);
        if(user == null) {
            json.put("success", false);
            json.put("message", userService.getErrorMessage());
            response.getWriter().println(json);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
    }

    /*更改用户信息*/
    private void changeInfo(HttpServletRequest request, HttpServletResponse response) {

    }

    /*更改用户类型，管理员<-->普通用户*/
    private void changeType(HttpServletRequest request, HttpServletResponse response) {

    }

    /*删除用户*/
    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    /*添加收藏夹*/
    private void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("addFavorite");
        User user = (User)request.getSession().getAttribute("user");
        if(user == null) {

        }else {
            FavoriteService favoriteService = new FavoriteServiceImpl();
            int artworkID = Integer.parseInt(request.getParameter("artworkID"));
            if(DaoFactory.getInstance().getFavoriteDao().addFavorite(user.getUserID(), artworkID)) {
                /*添加成功*/
            } else {
                /*添加失败*/
            }
        }
    }

    /*删除收藏夹*/
    private void deleteFavorite(HttpServletRequest request, HttpServletResponse response) {

    }

}
