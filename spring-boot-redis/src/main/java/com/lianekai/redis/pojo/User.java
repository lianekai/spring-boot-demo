package com.lianekai.redis.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/09 16:24
 */
@Getter
@Setter
@Builder
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private String sex;
}
