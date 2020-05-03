package com.bit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (username != null
                && username.equals("weihaibo")
                && password != null
                && password.equals("980622")) {
            // 登录成功
            writer.println("登录成功");
            System.out.println("登录成功");
        } else {
            // 登录失败
            writer.println("登录失败");
            System.out.println("登录失败");
        }
    }
}
