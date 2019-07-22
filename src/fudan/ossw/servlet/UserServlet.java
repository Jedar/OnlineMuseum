package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.DaoFactory;
import fudan.ossw.entity.Message;
import fudan.ossw.entity.Request;
import fudan.ossw.entity.User;
import fudan.ossw.service.FavoriteService;
import fudan.ossw.service.FriendService;
import fudan.ossw.service.MessageService;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.FavoriteServiceImpl;
import fudan.ossw.service.impl.FriendServiceImpl;
import fudan.ossw.service.impl.MessageServiceImpl;
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
import java.sql.Date;
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
            json.put("code",userService.getErrorCode());
            json.put("link",request.getContextPath());
            response.getWriter().println(json.toJSONString());
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            json.put("success", true);
            json.put("message", userService.getErrorMessage());
            json.put("code",userService.getErrorCode());
            json.put("link",request.getContextPath()+"/jsp/home.jsp");
            response.getWriter().println(json.toJSONString());
        }
    }

    /*用户登出*/
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        json.put("success", true);
        json.put("link",request.getContextPath()+"/jsp/home.jsp");
        response.getWriter().println(json.toJSONString());
    }

    /*用户注册*/
    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        User user = userService.signup(new User(-1, name, pwd, email, phone, address));
        if(user == null) {
            json.put("success", false);
            json.put("message", userService.getErrorMessage());
            json.put("code",userService.getErrorCode());
            json.put("link",request.getContextPath());
            response.getWriter().println(json);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            json.put("success", true);
            json.put("message", userService.getErrorMessage());
            json.put("code",userService.getErrorCode());
            json.put("link",request.getContextPath()+"/jsp/home.jsp");
            response.getWriter().println(json);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String manage = request.getParameter("manage");
        boolean isM = "true".equals(manage);
        User u = new User(-1, name, pwd, email, phone, address);
        u.setIsManager(isM);
        boolean flag = userService.insert(u);
        if(!flag) {
            json.put("success", false);
            json.put("message", userService.getErrorMessage());
            json.put("code",userService.getErrorCode());
            json.put("link",request.getContextPath()+"/jsp/peoplemanagement.jsp");
            response.getWriter().println(json);
        }else {
            json.put("success", true);
            json.put("message", userService.getErrorMessage());
            json.put("code",userService.getErrorCode());
            response.getWriter().println(json);
        }
    }

    /*更改用户信息*/
    private void changeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        String password = request.getParameter("password");
        if(!password.equals(user.getPassword())) {
            json.put("success", false);
            json.put("message", "密码错误");
        }else {
            String username = request.getParameter("username");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String signature = request.getParameter("signature");
            username = "".equals(username.trim())? user.getUsername() : username;
            address = "".equals(address.trim())? user.getAddress() : address;
            phone = "".equals(phone.trim())? user.getPhone() : phone;
            email = "".equals(email.trim())? user.getEmail() : email;
            signature = "".equals(signature.trim())? user.getSignature() : signature;
            User user1 = new User(user.getUserID(), username, password, email, phone, address);
            user1.setSignature(signature);
            UserService userService = new UserServiceImpl();
            if(userService.update(user1)) { //检测用户名是否重复
                json.put("success", true);
                user = userService.getUser(user.getUserID());
                request.getSession().setAttribute("user", user);
                json.put("username", user.getUsername());
                json.put("email", user.getEmail());
                json.put("phone", user.getPhone());
                json.put("address", user.getAddress());
                json.put("signature", user.getSignature());
            }else {
                json.put("success", false);
                json.put("message", "更新失败");
            }
        }
        response.getWriter().println(json);
    }

    /*更改用户类型，管理员<-->普通用户*/
    private void changeType(HttpServletRequest request, HttpServletResponse response) {
        UserService service = new UserServiceImpl();
        User user = (User)request.getSession().getAttribute("user");
        if (!user.getIsManager()){
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message","非法操作");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int userID = Integer.parseInt(request.getParameter("userID"));
        User target = userService.getUserByID(userID);
        if (target == null){
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message","用户不存在");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        target.setIsManager(!target.getIsManager());
        boolean flag = userService.update(target);
        if (flag){
            JSONObject object = new JSONObject();
            object.put("success",true);
            object.put("message","更改权限成功");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message",userService.getErrorMessage());
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*删除用户*/
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        boolean flag = userService.delete(userID);
        if (flag){
            JSONObject object = new JSONObject();
            object.put("success",true);
            object.put("message","删除用户成功");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            JSONObject object = new JSONObject();
            object.put("success",false);
            object.put("message","删除用户失败");
            try {
                response.getWriter().println(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*添加收藏夹*/
    private void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null) {
            json.put("success", false);
            json.put("message", "请先登陆");
        }else {
            FavoriteService favoriteService = new FavoriteServiceImpl();
            int artworkID = Integer.parseInt(request.getParameter("artworkID").trim());
            System.out.println("artworkID" + artworkID);
            if(favoriteService.addFavorite(user.getUserID(), artworkID)) {
                json.put("success", true);
            } else {
                json.put("success", false);
                json.put("message", favoriteService.getErrorMessage());
            }
        }
        System.out.println(json.toJSONString());
        response.getWriter().println(json.toJSONString());
    }

    /*删除收藏夹*/
    private void deleteFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int artworkID = Integer.parseInt(request.getParameter("artworkID"));
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        FavoriteService favoriteService = new FavoriteServiceImpl();
        if(favoriteService.deleteFavorite(userID, artworkID)){
            json.put("success", true);
        }else {
            json.put("success", false);
            json.put("message", "删除失败");
        }
        response.getWriter().println(json.toJSONString());
    }

    private void sendRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int senderID = ((User)request.getSession().getAttribute("user")).getUserID();
        String receiverName = request.getParameter("username");
        String content = request.getParameter("content");
        System.out.println("username:" + receiverName);
        User receiver = userService.getUserByName(receiverName.trim());
        if(receiver == null) {
            json.put("success", false);
            json.put("message", "用户不存在");
        }else{
            Request addRequest = new Request(-1, senderID, receiver.getUserID(), content, new Date(new java.util.Date().getTime()), false, false);
            FriendService friendService = new FriendServiceImpl();
            if(friendService.sendRequest(addRequest)) {
                json.put("success", true);
            }else {
                json.put("success", false);
                json.put("message", "发送失败");
            }
        }
        response.getWriter().println(json.toJSONString());
    }

    private void readRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int receiverID = ((User)request.getSession().getAttribute("user")).getUserID();
        int senderID  = Integer.parseInt(request.getParameter("senderID").trim());
        boolean agree = Boolean.parseBoolean(request.getParameter("agree"));
        FriendService friendService = new FriendServiceImpl();
        if(friendService.readRequest(senderID, receiverID, agree)){
            json.put("success", true);
        }else {
            json.put("success", false);
            json.put("message", "操作失败");
        }
        response.getWriter().println(json.toJSONString());
    }

    private void deleteFriend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        int friendID = Integer.parseInt(request.getParameter("friendID"));
        FriendService friendService = new FriendServiceImpl();
        if(friendService.deleteFriend(userID,friendID)) {
            json.put("success", true);
        }else {
            json.put("success", false);
            json.put("message", "删除失败");
        }
        response.getWriter().println(json.toJSONString());
    }

    private void sendMessage(HttpServletRequest request, HttpServletResponse response) {
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        int friendID = Integer.parseInt(request.getParameter("friendID"));
        String content = request.getParameter("content");
        Message message = new Message(-1, userID, friendID, content, new Date(new java.util.Date().getTime()), false);
        MessageService messageService = new MessageServiceImpl();
        if(messageService.sendMessage(message)){
            json.put("success", true);
        }else {
            json.put("success", false);
            json.put("message", "发送失败");
        }
    }

    private void readMessage(HttpServletRequest request, HttpServletResponse response) {
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        MessageService messageService = new MessageServiceImpl();
        messageService.readMessage(messageID);
    }

    private void deleteMessage(HttpServletRequest request, HttpServletResponse response) {
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        MessageService messageService = new MessageServiceImpl();
        messageService.deleteMessage(messageID);
    }
}
