package com.lianekai.easyexcel.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 动态导入数据的返回结果VO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/11 21:03
 */
@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "导入Excel 动态数据返回结果VO", description = "导入Excel 动态数据返回结果VO")
@ToString
public class DynamicExcelResultVO {
    /**
     * 动态表头 可能存在行表头，这里也用List来存  一个map代表一列的数据  list多行
     */
    @ApiModelProperty(value = "动态表头", example = "{\"num\":\"*序号\",\"name\":\"*任务名称\"}")
    List<Map<String, String>> headMap;
    /**
     * 动态表数据  Map 是一行数据 的各个列的数据  List 多行
     */
    @ApiModelProperty(value = "动态表数据", example = "[{\"num\":\"1\",\"name\":\"任务123\"}]")
    List<Map<String, Object>> dataList;

    @ApiModelProperty(value = "总校验结果", example = "true")
    private Boolean result;

    /**静态new实例方法*/
    public static DynamicExcelResultVO of(){
        return new DynamicExcelResultVO();
    }

}
