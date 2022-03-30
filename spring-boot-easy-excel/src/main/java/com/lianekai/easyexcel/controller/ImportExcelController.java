package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.api.ImportRouteApi;
import com.lianekai.easyexcel.common.Response;
import com.lianekai.easyexcel.pojo.dto.ImportParamDTO;
import com.lianekai.easyexcel.pojo.vo.DynamicExcelResultVO;
import com.lianekai.easyexcel.service.ExcelHandlerService;
import com.lianekai.easyexcel.utils.ExcelListener;
import com.lianekai.easyexcel.utils.ExcelUtil;
import com.lianekai.easyexcel.pojo.vo.FactoryExcelVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 18:07
 */
@RestController
public class ImportExcelController implements ImportRouteApi{

    @Autowired
    ExcelHandlerService excelHandlerService;

    @Override
    public Response<List<FactoryExcelVO>> importExcel(MultipartFile file) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        List<FactoryExcelVO> list=  ExcelUtil.getExcelDataList(file.getInputStream(), FactoryExcelVO.class,excelListener);
        Response<List<FactoryExcelVO>> response=new Response<>();
        response.setCode(200);
        response.setMessage("导出数据成功");
        response.setData(list);
        return response;
    }

    @ApiOperation(value = "导入动态数据", httpMethod = "POST")
    @PostMapping("/excel/importDynamicExcel")
    public Response<DynamicExcelResultVO> importDynamicExcel(@ApiParam("导入file对象") MultipartFile file, @ApiParam("导入参数DTO") ImportParamDTO importParams){
        return Response.returnSuccess(this.excelHandlerService.importDynamicExcel(file,importParams));
    }




}
