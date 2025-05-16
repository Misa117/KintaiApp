<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        return;
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>勤怠管理</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2><%= user.getName() %> さんの勤怠</h2>
        <form action="<%= request.getContextPath() %>/attendance" method="post">
            <button name="action" value="in">出勤</button>
            <button name="action" value="out">退勤</button>
        </form>
        <p class="record"><%= session.getAttribute("record") == null ? "" : session.getAttribute("record") %></p>
        
        <!-- ここからアカウント作成ボタン -->
        <form action="<%= request.getContextPath() %>/jsp/register.jsp" method="get">
            <button type="submit">アカウント作成</button>
        </form>
    </div>
</body>
</html>
