package fudan.ossw.filter;

import fudan.ossw.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/20 21:17
 * @Version 1.0
 **/
public class LoginFilter implements Filter {
    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;
    public LoginFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        //获取XML文件中配置参数
        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("redirectPage");
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String servletPath = httpRequest.getServletPath();
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
//        if (urls.contains(servletPath)) {
//            filterChain.doFilter(httpRequest, httpResponse);
//            return;
//        }
//        User user = (User)httpRequest.getSession().getAttribute(sessionKey);
//        if ((user == null)) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
//            return;
//        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
