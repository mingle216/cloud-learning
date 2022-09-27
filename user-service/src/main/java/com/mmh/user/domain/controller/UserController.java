package com.mmh.user.domain.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mmh.user.common.ResponseResult;
import com.mmh.user.common.ResultCode;
import com.mmh.user.domain.dto.UserDto;
import com.mmh.user.domain.enitiy.User;
import com.mmh.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mingle
 * @date 2022/9/6 17:26
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    @SentinelResource(value="getUserById",blockHandler = "getNoticeBlock")
    public ResponseResult getUserById(@PathVariable Integer id) {
        return ResponseResult.success(userService.findById(id));
    }

    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = userService.login(userDto);

        System.out.println(user);
        if(user == null) {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        } else {
            return ResponseResult.success(user);
        }
    }
    public ResponseResult getNoticeBlock(BlockException exception){
        log.info("接口被限流");
        log.info(exception.toString());
        return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
    }
}
