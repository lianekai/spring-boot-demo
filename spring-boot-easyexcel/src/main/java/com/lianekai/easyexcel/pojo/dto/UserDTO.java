package com.lianekai.easyexcel.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户入参DTO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/11/23 23:59
 */
@Getter
@Setter
@ToString
public class UserDTO {

    @NotNull
    @Length(min = 2, max = 10)
    private String name;

    @NotNull
    @Length(min = 6, max = 20)
    private String password;

    @NotNull
    @Length(min = 6, max = 20)
    private String sex;


}
