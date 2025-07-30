package com.lianekai.easyexcel.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lianyikai
 * @date 2025年04月26日 15:23
 */
@Data
public class CustomsPassPortExcelVo {

    @ExcelProperty(value = "序号")
    private String num;
    @ExcelProperty(value = "核放单编号")
    private String passportNo;
    @ExcelProperty(value = "变更次数")
    private Integer changeCount;
    @ExcelProperty(value = "核放单类型")
    private String passportType;
    @ExcelProperty(value = "进出标识")
    private String ieFlag;
    @ExcelProperty(value = "绑定类型")
    private String bindType;
    @ExcelProperty(value = "关联单证类型")
    private String rtlDocType;
    @ExcelProperty(value = "关区名称")
    private String customsName;
    @ExcelProperty(value = "车牌号")
    private String licencePlate;
    @ExcelProperty(value = "状态")
    private String passType;
    @ExcelProperty(value = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime passTime;
    @ExcelProperty(value = "企业海关注册编码")
    private String enterpriseCode;
    @ExcelProperty(value = "区内企业名称")
    private String enterpriseName;
    @ExcelProperty(value = "审批标识")
    private String checkFlag;
    @ExcelProperty(value = "IC卡（实际为车牌号）")
    private String realPassLicencePlate;
    @ExcelProperty(value = "集装箱号")
    private String containerNo;


}
