package fudan.ossw.filter;

import fudan.ossw.data.ScopeKey;
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
    private String encoding;
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
        encoding = servletContext.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        /* 设置编码 */
        httpRequest.setCharacterEncoding(encoding);
        httpResponse.setCharacterEncoding(encoding);

        /* 获取网页白名单 */
        String servletPath = httpRequest.getServletPath();
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        /* 如果在白名单内，通过过滤器 */
        if (urls.contains(servletPath)) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        User user = (User)httpRequest.getSession().getAttribute(sessionKey);
        /* 未登录拦截 */
        if ((user == null)) {
            httpRequest.getSession().setAttribute(ScopeKey.blockPage,httpRequest.getServletPath());

            httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
            return;
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
