package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //判断是否是敏感资源，若是获取session，获取不到，重定向到登陆页面
        String uri = req.getServletPath();
        if (!uri.startsWith("/public/") && !uri.startsWith("/static/") && !"/user/login".equals(uri)) {
            HttpSession session = req.getSession(false);
            if (session == null) {
                //没有登录，不允许访问
                //用绝对路径，不能用相对路径
                //res.sendRedirect("/ses/public/index.html");
                String schema = req.getScheme();
                String host = req.getServerName();
                int port = req.getServerPort();
                String contextPath = req.getContextPath();
                String basePath = schema+"://"+host+":"+port+contextPath;
                res.sendRedirect(basePath+"/public/index.html");
                return;
            }
        }
        chain.doFilter(request,response);   //没有非敏感资源，或敏感资源登陆以后，继续调用后续配置资源
    }
}
