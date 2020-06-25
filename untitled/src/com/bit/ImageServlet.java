package com.bit;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/i")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        byte[] buffer = Image.getById(id);
        if (buffer == null) {
            resp.sendError(404, "没有这个图片");
            return;
        }

        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(buffer);
        outputStream.flush();
    }
}
