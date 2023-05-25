package com.lianekai.easyexcel.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 20:04
 */
@Slf4j
public class ExcelUtil<T> {
    private static final String XLS = ".xls";
    private static final String XLSX = ".xlsx";

    private ExcelUtil() {
    }
    Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }


    /***
     * 判断文件格式
     * @param is is
     * @param fileName fileName
     * @return
     * @version: 1.0
     * @date: 2020/12/04
     * @author: yikai.lian
     */

    public static Workbook getWorkbook(InputStream is,String fileName) throws IOException {
        Workbook workbook=null;
        String fileType=fileName.substring(fileName.lastIndexOf('.'));
        if (XLS.equals(fileType)) {
            workbook = new HSSFWorkbook(is);
            return workbook;
        }
        if (XLSX.equals(fileType)) {
            // jdk 1.7 try with resource用法  自动关闭资源
            try (OPCPackage opcPackage = OPCPackage.open(is);) {
                workbook = new XSSFWorkbook(opcPackage);
            } catch (Exception e) {
                log.error("fileName:{} and errorMessage:{}", fileName, e.getMessage(), e);
            }
        }
        return workbook;
    }

    /**
     * 判断表格数据是否为空
     *
     * @param workbook
     * @return
     */
    public static boolean isEmpty(Workbook workbook,int sheetNum){
        return workbook.getSheetAt(sheetNum).getFirstRowNum() == workbook.getSheetAt(sheetNum).getLastRowNum();
    }


    public static <T> List<T> getExcelDataList(InputStream inputStream,Class<T> targetCass, ExcelListener excelListener){
        //读取的数据
        /** EasyExcel.read(inputStream, targetCass, excelListener).sheet().doRead();*/
        //获取读取的数据
        List<Object> dataList = excelListener.getDataList();
        //定义返回的结果
        List<T> listResult = new ArrayList<>();
        try {
            //循环转换
            for (Object obj : dataList) {
                T target = targetCass.newInstance();
                listResult.add(target);
                BeanUtils.copyProperties(obj, target);
                inputStream.close();
            }
        } catch (Exception e) {
            log.info("获取数据错误", e);
        }
        return listResult;
    }


}
