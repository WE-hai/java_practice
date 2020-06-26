package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/publish")
@MultipartConfig
public class PublishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 0. 先检查用户是否已经登录，如果没有登录，302 到 /login.html
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.html");
            return;
        }

        // 1. 读取用户输入信息
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        Part imagePart = req.getPart("image");

        // 2. TODO: 合法性校验

        // 3. 存储图片信息
        Image image = Image.save(imagePart);

        // 4. 存储文章信息
        Article article = Article.publish(user, title, image, body);

        // 5. 跳转到新发表文章的详情页
        resp.sendRedirect("/a?id=" + article.id);
    }
}
