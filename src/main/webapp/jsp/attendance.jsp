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
    <title>勤怠管理</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2><%= user.getName() %> さんの勤怠</h2> <!-- ここを修正 -->
        <form action="<%= request.getContextPath() %>/attendance" method="post">
            <button name="action" value="in">出勤</button>
            <button name="action" value="out">退勤</button>
        </form>
        <p class="record"><%= session.getAttribute("record") == null ? "" : session.getAttribute("record") %></p>
    </div>
</body>
</html>
