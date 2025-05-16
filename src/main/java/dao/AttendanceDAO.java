package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import util.DBUtil;

public class AttendanceDAO {

    // 出勤時間を記録
    public static void markStartTime(int userId) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        String checkSql = "SELECT id FROM attendance WHERE user_id = ? AND date = ?";
        String insertSql = "INSERT INTO attendance (user_id, date, start_time) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, userId);
            checkStmt.setDate(2, java.sql.Date.valueOf(today));
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                    insertStmt.setInt(1, userId);
                    insertStmt.setDate(2, java.sql.Date.valueOf(today));
                    insertStmt.setTimestamp(3, Timestamp.valueOf(now));
                    insertStmt.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 退勤時間を記録
    public static void markEndTime(int userId) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        String updateSql = "UPDATE attendance SET end_time = ? WHERE user_id = ? AND date = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            updateStmt.setTimestamp(1, Timestamp.valueOf(now));
            updateStmt.setInt(2, userId);
            updateStmt.setDate(3, java.sql.Date.valueOf(today));
            updateStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
