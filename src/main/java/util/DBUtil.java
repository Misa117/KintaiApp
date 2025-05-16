package util; // 実際のパッケージ名に変更してください

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String JDBC_URL = "jdbc:h2:~/kintaiDB"; // H2のDBパス
    private static final String JDBC_USER = "sa"; // ユーザー名（デフォルトはsa）
    private static final String JDBC_PASSWORD = ""; // パスワード（通常は空）

    static {
        try {
            Class.forName("org.h2.Driver"); // ドライバのロード
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // データベース接続を取得するメソッド
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // 接続を安全に閉じるためのメソッド（必要に応じて使えます）
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
