package com.lianekai.big.data.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * CustomsDataService
 *
 * @author lianyikai
 * @date 2025/3/10 18:55
 */
@Service
public class CustomsDataService {

    @Autowired
    @Qualifier("clickhouseJdbcTemplate")
    private JdbcTemplate clickhouseJdbcTemplate;

    public BigDecimal getTotalTradeValue() {
        String sql = "SELECT SUM(trade_value) AS total_trade_value FROM customs_data WHERE trade_date >= '2024-01-01' AND trade_date <= '2024-12-31'";
        return clickhouseJdbcTemplate.queryForObject(sql, BigDecimal.class);
    }

    public int getTotalTradeVolume() {
        String sql = "SELECT SUM(trade_volume) AS total_trade_volume FROM customs_data WHERE trade_date >= '2024-01-01' AND trade_date <= '2024-12-31'";
        return clickhouseJdbcTemplate.queryForObject(sql, Integer.class);
    }

}
