package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.service.ExcelHandlerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 导出excel 控制器
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/09/20 21:31
 */
public class ExportExcelController extends BaseExcelHandler{
    @Autowired
    ExcelHandlerService excelHandlerService;

    @ApiOperation(value = "动态生成Excel模板", httpMethod = "POST")
    @PostMapping("/export/generateExcelTemplate")
    public void generateExcelTemplate(HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode("计划导入动态模板", StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
        super.setResponseHeadAsExcel(response, fileName);
        excelHandlerService.generateExcelTemplate(response);
    }

}
