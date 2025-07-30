package com.lianekai.easyexcel.api;

import com.alibaba.excel.EasyExcel;
import com.lianekai.easyexcel.pojo.vo.CustomsPassPortExcelVo;
import com.lianekai.easyexcel.utils.ExcelListener;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author lianyikai
 * @date 2025年04月26日 15:40
 */
@RestController
@RequestMapping("excel-import")
public class ExcelParseController {

    @RequestMapping("/passportDataParse")
    public boolean customsDataSync(MultipartFile file) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        EasyExcel.read(file.getInputStream(), CustomsPassPortExcelVo.class, excelListener).sheet().doRead();
        List<Object> excelDataList =  excelListener.getDataList();
        return !CollectionUtils.isEmpty(excelDataList);
    }
}
