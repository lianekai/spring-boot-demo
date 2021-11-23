package com.lianekai.easyexcel.service;

import javax.servlet.http.HttpServletResponse;

/**
 * excel处理服务
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/09/20 21:51
 */
public interface ExcelHandlerService {
    /**
     * 生成Excel模板
     * @return
     * @param response
     */
    Boolean generateExcelTemplate(HttpServletResponse response);
}
