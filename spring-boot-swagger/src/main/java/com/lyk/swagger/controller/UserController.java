package com.lyk.swagger.controller;

import com.lyk.swagger.api.ApiResponse;
import com.lyk.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyk
 * @version: 1.0
 * @date 14:02
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.0",description = "用户管理",value = "用户管理")
@Slf4j
public class UserController {
    @GetMapping
    @ApiOperation(value = "条件查询（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name="username",value = "用户名")})
    public ApiResponse<User> getByUserName(String username){
        log.info("多个参数用  @ApiImplicitParams");
        return ApiResponse.<User>builder().code(200)
                .message("操作成功")
                .data(new User(username, "JAVA"))
                .build();
    }
}
