<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>勤怠チェックアプリ - ホーム</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h1>ようこそ 勤怠チェックアプリへ</h1>
        <p>出勤・退勤の打刻を簡単に管理できます。</p>
        
        <form action="<%= request.getContextPath() %>/jsp/login.jsp" method="get">
            <button type="submit">ログイン</button>
        </form>

        <form action="<%= request.getContextPath() %>/jsp/register.jsp" method="get">
            <button type="submit">アカウント作成</button>
        </form>
    </div>
</body>
</html>
