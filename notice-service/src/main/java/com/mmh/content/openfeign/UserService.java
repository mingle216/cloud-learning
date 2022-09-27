package com.mmh.content.openfeign;

import com.mmh.content.common.ResponseResult;
import com.mmh.content.openfeign.fallback.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiangyiheng
 * @date 2022-09-06 18:19
 */
//@FeignClient(value = "user-service",path = "/users",fallback = UserServiceFallBackImpl.class)
@FeignClient(value = "user-service",path = "/user",fallbackFactory = UserServiceFallbackFactory.class)
public interface UserService {
    /**
     * 调用user模块服务
     * @param id
     * @return
     */
    @GetMapping("{id}")
    ResponseResult getUser(@PathVariable("id") int id);
}
