package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/a")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Article article = Article.getById(id);
        if (article == null) {
            resp.sendError(404, "没有这篇文章");
            return;
        }

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='utf-8'>");
        writer.println("<title>文章 | " + article.title + "</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>" + article.title + "</h1>");
        writer.println("<h2>" + article.author.username + "</h2>");
        writer.println("<img src='/i?id=" + article.image.id + "'>");
        writer.println("<p>");
        writer.println(article.body);
        writer.println("</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
