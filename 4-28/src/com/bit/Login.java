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
        // 从 query string 中获取用户输入的 username 和 password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 设置 HTTP 响应的 Content-Type Header
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 验证用户名密码是否正确（username 是 peixinchen 并且 password 是 gogogo）
        if (username != null
                && username.equals("lijingjing")
                && password != null
                && password.equals("123456")) {

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