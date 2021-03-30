package com.example.demo.filter;

import com.example.demo.controller.Webpage;
import com.example.demo.entity.UsersEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Access middleware");
        UsersEntity user = null;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", -1);

        String requestedURI = httpServletRequest.getRequestURI();
        if (requestedURI.contains("client")) {

            if ((user = (UsersEntity) httpServletRequest.getSession().getAttribute("user")) != null) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.sendRedirect(Webpage.LOGIN_PAGE);
            }
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

    /*
    //    @Override
    public void doFilter2(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uriPath = request.getRequestURI();
        if (uriPath.contains(Webpage.USER_PROFILE)) {
            if ((user = (User) request.getSession().getAttribute("user")) != null){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                servletResponse.getWriter().append("403 - Access denied");
                return;
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

     */

    @Override
    public void destroy() {

    }
}
