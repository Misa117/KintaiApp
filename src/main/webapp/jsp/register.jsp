<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ユーザー登録</title>
</head>
<body>
    <h2>新規登録フォーム</h2>
    <form action="RegisterServlet" method="post">
        名前：<input type="text" name="name" required><br>
        社員番号：<input type="text" name="employeeNumber" required><br>  <!-- 修正 -->
        パスワード：<input type="password" name="password" required><br>
        <input type="submit" value="登録">
    </form>
    <c:if test="${not empty errorMsg}">
        <p style="color:red">${errorMsg}</p>
    </c:if>
</body>
</html>
