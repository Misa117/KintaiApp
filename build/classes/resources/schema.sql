-- アカウント情報を保存するテーブル
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    employee_number VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- 勤怠打刻履歴を保存するテーブル
CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
