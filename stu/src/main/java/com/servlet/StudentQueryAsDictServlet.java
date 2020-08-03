package com.servlet;

import com.dao.StudentDAO;
import com.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = StudentDAO.queryAsDict(Integer.parseInt(id));
        return tags;
    }
}
