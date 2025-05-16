<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>アカウント作成</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>アカウント作成</h2>
        <form action="<%= request.getContextPath() %>/register" method="post">
            <input type="text" name="name" placeholder="名前" required><br>
            <input type="text" name="employeeId" placeholder="社員番号" required><br>
            <input type="password" name="password" placeholder="パスワード" required><br>
            <input type="submit" value="登録">
        </form>
        <p class="error"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
    </div>
</body>
</html>
