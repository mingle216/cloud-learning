package com.mmh.content.openfeign;

import com.mmh.content.common.ResponseResult;

import com.mmh.content.openfeign.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mingle
 * @date 2022/9/6 20:09
 */
//@FeignClient(value = "user-center",path = "/user")
@FeignClient(value = "user-center",path = "/user",fallback = UserServiceFallback.class)
public interface UserService {
    /**
     * 根据id查询用户
     * @param id id
     * @return ResponseResult
     */
    @GetMapping("{id}")
    ResponseResult getUser(@PathVariable(value="id") int id);
}
