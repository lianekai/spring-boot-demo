package com.lianekai.easyexcel.controller;

import javax.servlet.http.HttpServletResponse;

/**
 * 基础Excel处理拦截类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/09/20 21:48
 */
public class BaseExcelHandler {

    protected void setResponseHeadAsExcel(HttpServletResponse response, String fileName) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=utf-8''" + fileName);
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
    }
}
