package com.lianekai.easyexcel.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 20:42
 */
@Setter
@Getter
public class FactoryExcelVO {
    /**
     * 校验结果信息
     */
    private String checkResultMessage;
    /**
     * 序号
     */
    @ExcelProperty(value = "序号")
    private String num;
    /**
     * bom编码
     */
    @NotBlank(message = "bom_import_bom_1073")
    @ExcelProperty(value = "*物料编码")
    private String matCode;
    /**
     * bom名称
     */
    @NotBlank(message = "bom_import_bom_1074")
    @ExcelProperty(value = "物料描述")
    private String note;

    /**
     *  BOM状态
     */
    @ExcelProperty(value = "BOM状态")
    private String statusCode;

    /**
     * 国内组包工厂
     */
    @Pattern(regexp = "[0-9a-zA-Z\\,\\s]*${1,}$", message = "bom_import_bom_1047")
    @ExcelProperty("国内组包工厂")
    private String homePackagingFactory;
    /**
     * 国内贴片工厂
     */
    @Pattern(regexp = "[0-9a-zA-Z\\,\\s]*${1,}$", message = "bom_import_bom_1048")
    @ExcelProperty(value = "国内贴片工厂")
    private String homeChipFactory;
    /**
     * 海外组包工厂
     */
    @Pattern(regexp = "[0-9a-zA-Z\\,\\s]*${1,}$", message = "bom_import_bom_1049")
    @ExcelProperty(value = "海外组包工厂")
    private String overseasPackagingFactory;
    /**
     * 海外贴片工厂
     */
    @Pattern(regexp = "[0-9a-zA-Z\\,\\s]*${1,}$", message = "bom_import_bom_1050")
    @ExcelProperty(value = "海外贴片工厂")
    private String overseasChipFactory;
    /**
     * 正确物料描述
     */
    private String rightNote;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}