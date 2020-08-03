package com.servlet;

import com.dao.UserDAO;
import com.model.User;
import com.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
////        resp.setContentType("text/html");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.printf("username=%s,password=%s\n",username,password);
////        PrintWriter pw = resp.getWriter();
////        pw.println("登陆成功");
////        pw.flush();
//        PrintWriter pw = resp.getWriter();
//        pw.println(new ObjectMapper().writeValueAsString(Response.ok()));
//        pw.flush();
//    }

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = JSONUtil.read(req.getInputStream(),User.class);
        User queryUser = UserDAO.query(user);
        if (queryUser == null) {
            throw new RuntimeException("用户名密码校验失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",queryUser);
        return null;
    }
}
