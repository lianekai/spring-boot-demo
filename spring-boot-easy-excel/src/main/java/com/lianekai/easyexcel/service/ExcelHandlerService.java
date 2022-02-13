package com.lianekai.easyexcel.service;

import com.lianekai.easyexcel.pojo.dto.ImportParamDTO;
import com.lianekai.easyexcel.pojo.vo.DynamicExcelResultVO;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;

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

    DynamicExcelResultVO importDynamicExcel(MultipartFile file, ImportParamDTO importParams);
}
