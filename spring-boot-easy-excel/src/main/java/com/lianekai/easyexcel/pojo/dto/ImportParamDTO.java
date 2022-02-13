package com.lianekai.easyexcel.pojo.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/11 21:11
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString
@ApiModel(value = "导入Excel业务参数DTO", description = "导入Excel业务参数DTO")
public class ImportParamDTO {
    /**这个写各种业务参数*/
}
