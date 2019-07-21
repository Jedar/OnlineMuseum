package fudan.ossw.servlet;

import fudan.ossw.entity.User;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PeopleManagementPageServlet", value = "/jsp/peoplemanagement.jsp")
public class PeopleManagementPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();

        User user = (User)req.getSession().getAttribute("user");

        List<User> users = service.getAllUser();

        req.setAttribute("users",users);
        req.setAttribute("user",user);

        req.getRequestDispatcher("./peoplemanagement_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
