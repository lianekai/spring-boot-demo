package com.lianekai.easyexcel.service.impl;

import com.google.common.collect.Lists;
import com.lianekai.easyexcel.service.ExcelHandlerService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 生成excel 模板实现类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/09/20 21:52
 */
@Service
public class ExcelHandlerServiceImpl implements ExcelHandlerService {
    @Override
    public Boolean generateExcelTemplate(HttpServletResponse response) {
        List<String> headers= Lists.newArrayList();
        return null;
    }
}
