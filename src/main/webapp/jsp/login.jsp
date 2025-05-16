<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ログイン</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>勤怠チェックアプリにようこそ</h2>

        <form action="LoginServlet" method="post">
    <label for="employeeNumber">社員番号:</label>
    <input type="text" id="employeeNumber" name="employeeNumber" required>

    <label for="password">パスワード:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">ログイン</button>
</form>
        

        <p class="error"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
    </div>
</body>
</html>
