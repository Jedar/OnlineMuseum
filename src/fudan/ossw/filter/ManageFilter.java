package fudan.ossw.filter;

import fudan.ossw.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ManageFilter")
public class ManageFilter implements Filter {
    private String homePage;
    private String sessionKey;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        User user = (User)httpRequest.getSession().getAttribute(sessionKey);
        if ((user == null)) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + homePage);
            return;
        }
        if (!user.getIsManager()){
            httpResponse.sendRedirect(httpRequest.getContextPath() + homePage);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        //获取XML文件中配置参数
        homePage = servletContext.getInitParameter("homePage");
        sessionKey = servletContext.getInitParameter("userSessionKey");
    }

}
