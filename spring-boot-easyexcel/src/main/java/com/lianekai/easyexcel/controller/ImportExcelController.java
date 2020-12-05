package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.api.ImportRouteApi;
import com.lianekai.easyexcel.commons.Response;
import com.lianekai.easyexcel.utils.ExcelListener;
import com.lianekai.easyexcel.utils.ExcelUtil;
import com.lianekai.easyexcel.vo.BomFactoryExcelVO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 18:07
 */
@RestController
public class ImportExcelController implements ImportRouteApi{
    @Override
    public Response<List<BomFactoryExcelVO>> importExcel(MultipartFile file) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        List<BomFactoryExcelVO> list=  ExcelUtil.getExcelDataList(file.getInputStream(), BomFactoryExcelVO.class,excelListener);
        Response<List<BomFactoryExcelVO>> response=new Response<>();
        response.setCode(200);
        response.setMessage("导出数据成功");
        response.setData(list);
        return response;
    }
}
