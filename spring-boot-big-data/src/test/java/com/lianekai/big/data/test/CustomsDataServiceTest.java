package com.lianekai.big.data.test;

import com.lianekai.big.data.BigDataApplication;
import com.lianekai.big.data.service.CustomsDataService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * 单元测试
 *
 * @author lianyikai
 * @date 2025/3/11 10:40
 */
@SpringBootTest(classes = BigDataApplication.class)
public class CustomsDataServiceTest {

    @Autowired
    private CustomsDataService customsDataService;

    @MockBean
    private JdbcTemplate clickhouseJdbcTemplate;

    @BeforeEach
    public void setUp() {
        // 模拟 getTotalTradeValue 方法的返回值
        when(clickhouseJdbcTemplate.queryForObject(anyString(), BigDecimal.class))
                .thenReturn(new BigDecimal("1000000.00"));

        // 模拟 getTotalTradeVolume 方法的返回值
        when(clickhouseJdbcTemplate.queryForObject(anyString(), Integer.class))
                .thenReturn(5000);
    }

    @Test
    public void testGetTotalTradeValue() {
        BigDecimal totalTradeValue = customsDataService.getTotalTradeValue();
        System.out.println("totalTradeValue = " + totalTradeValue);
        Assertions.assertEquals(new BigDecimal("1000000.00"), totalTradeValue);
    }

    @Test
    public void testGetTotalTradeVolume() {
        int totalTradeVolume = customsDataService.getTotalTradeVolume();
        System.out.println("totalTradeVolume = " + totalTradeVolume);
        Assertions.assertEquals(5000, totalTradeVolume);
    }
}
