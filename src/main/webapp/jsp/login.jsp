<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>ログイン</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2><%= user.getName() %> さんの勤怠</h2>
        
        <form action="<%= request.getContextPath() %>/login" method="post">
            <input type="text" name="username" placeholder="ユーザー名"><br>
            <input type="password" name="password" placeholder="パスワード"><br>
            <input type="submit" value="ログイン">
        </form>
        <p class="error"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
    </div>
</body>
</html>
