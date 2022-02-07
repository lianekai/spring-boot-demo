package com.lianekai.easyexcel.common;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 导入类型枚举
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/12/25 14:35
 */
@Getter
public enum ExcelTypeEnum {
    ROLE("role",ExcelHeader.roleHeader);

    /**excel的类型*/
    String excelType;
    /**excel的表头*/
    List<String> headerList;

    ExcelTypeEnum(String excelType,List<String> headerList){
        this.excelType=excelType;
        this.headerList=headerList;
    }

    public static Boolean checkHeader(String excelType,List<String> header){
        if(CollectionUtils.isEmpty(header)|| StringUtils.isEmpty(excelType)){
            return Boolean.FALSE;
        }
        for(ExcelTypeEnum typeEnum:values()){
            if(typeEnum.excelType.equals(excelType)&&typeEnum.headerList.containsAll(header)&&typeEnum.headerList.size()==header.size())
            {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    private static class ExcelHeader{
        private static final List<String> roleHeader= Lists.newArrayList("序号","角色名称");
    }
}
