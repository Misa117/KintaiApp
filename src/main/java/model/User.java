package model;

public class User {
    private String employeeId;  // 社員番号（ログインIDとして使用）
    private String password;    // パスワード
    private String name;        // ユーザーの名前

    public User(String employeeId, String password, String name) {
        this.employeeId = employeeId;
        this.password = password;
        this.name = name;
    }

    // パスワード照合
    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }

    // 社員番号取得
    public String getEmployeeId() {
        return employeeId;
    }

    // ユーザー名取得
    public String getName() {
        return name;
    }
}
