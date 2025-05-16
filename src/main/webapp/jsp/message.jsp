<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>メッセージ</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2><%= session.getAttribute("message") != null ? session.getAttribute("message") : "" %></h2>
        <p class="record"><%= session.getAttribute("record") != null ? session.getAttribute("record") : "" %></p>
        <form action="<%= request.getContextPath() %>/jsp/home.jsp" method="get">
            <button type="submit">ホームに戻る</button>
        </form>
    </div>
</body>
</html>
