package fudan.ossw.servlet;

import com.alibaba.fastjson.JSONObject;
import fudan.ossw.dao.NormalUserDao;
import fudan.ossw.dao.impl.NormalUserDaoImpl;
import fudan.ossw.entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SignUpServlet",value = "/jsp/SignUp")
public class SignUpServlet extends HttpServlet {
    private NormalUserDao normalUserDao = new NormalUserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        if(checkEmpty(name,"user name",response)){
            return;
        }
        if(checkEmpty(pwd,"password",response)){
            return;
        }
        if(checkEmpty(address,"address",response)){
            return;
        }
        if(checkEmpty(phone,"phone",response)){
            return;
        }
        if(checkEmpty(email,"email",response)){
            return;
        }
        name = name.trim();
        pwd = pwd.trim();
        address = address.trim();
        phone = phone.trim();
        email = email.trim();
        NormalUser newUser = new NormalUser(1,name,pwd,email,phone,address);

        NormalUser user = normalUserDao.getUserByName(name);

        JSONObject json = new JSONObject();

        if(user != null){
            json.put("success",false);
            json.put("message","Error:User name exists,try anther one");
            response.getWriter().println(json.toJSONString());
        }
        else{
            normalUserDao.addUser(newUser);

            HttpSession session = request.getSession();
            session.setAttribute("username",name);
            session.setAttribute("wish",new ArrayList<Integer>());
            session.setAttribute("isLogin",true);

            response.getWriter().println();

            json.put("success",true);
            json.put("message","Success");
            response.getWriter().println(json.toJSONString());
        }
    }

    private boolean checkEmpty(String para,String msg,HttpServletResponse response) throws IOException{
        JSONObject json = new JSONObject();
        if(para == null || "".equals(para.trim())){
            json.put("success",false);
            json.put("message","You must enter "+msg);
            response.getWriter().println(json.toJSONString());
            return true;
        }
        return false;
    }
}
