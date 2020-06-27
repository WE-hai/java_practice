<%@ page import="com.bit.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.html");
        return;
    }
%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>发表文章</title>
    </head>
    <body>
        <h1>发表文章</h1>
        <a href="/logout">退出</a>
        <form method="post" action="/publish" enctype="multipart/form-data">
            <div>
                <label>标题: </label>
                <input type="text" name="title">
            </div>
            <div>
                <label>头图: </label>
                <input type="file" name="image">
            </div>
            <div>
                <label>正文: </label>
                <textarea name="body"></textarea>
            </div>
            <div>
                <button type="submit">发表</button>
            </div>
        </form>
    </body>
</html>
