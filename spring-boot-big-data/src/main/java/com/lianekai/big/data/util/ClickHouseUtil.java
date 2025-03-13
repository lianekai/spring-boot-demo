package com.lianekai.big.data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClickHouseUtil
 *
 * @author lianyikai
 * @date 2025/3/10 18:30
 */
public class ClickHouseUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:clickhouse://localhost:8123"; // 根据实际情况修改URL和端口号
        return DriverManager.getConnection(url);
    }
}
