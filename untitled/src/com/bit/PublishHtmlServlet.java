package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/publish.html")
public class PublishHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取当前用户信息，如果用户未登录，跳转到登录页面
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 用户未登录
            resp.sendRedirect("/login.html");
            return;
        }

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>发表文章</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>发表文章</h1>\n" +
                "    <a href=\"/logout\">退出</a>\n" +
                "    <form method=\"post\" action=\"/publish\" enctype=\"multipart/form-data\">\n" +
                "        <div>\n" +
                "            <label>图片</label>\n" +
                "            <input type=\"file\" name=\"image\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>标题</label>\n" +
                "            <input type=\"text\" name=\"title\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>正文</label>\n" +
                "            <textarea name=\"body\"></textarea>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <button type=\"submit\">发表</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(htmlContent);
    }
}
