package com.lianekai.easyexcel.api;

import com.lianekai.easyexcel.common.Response;
import com.lianekai.easyexcel.pojo.vo.FactoryExcelVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 导入路由api
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 18:05
 */

@RequestMapping("/")
public interface ImportRouteApi {
    @PostMapping("/importData")
    public Response<List<FactoryExcelVO>> importExcel(MultipartFile file) throws IOException;
}
