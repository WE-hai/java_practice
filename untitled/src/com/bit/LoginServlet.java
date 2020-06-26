package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取用户输入
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. TODO: 合法性校验

        // 3. 从 MySQL 中查询登录的用户
        User user = User.getByUsernameAndPassword(username, password);
        if (user == null) {
            // 给出提示 OR 302 到 /login.html
            resp.sendRedirect("/login.html");
            return;
        }

        // 4. 写入 Session 中，表示登录成功
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        // 5. 登录成功，跳转到文章发表页面
        resp.sendRedirect("/publish.jsp");
    }
}
