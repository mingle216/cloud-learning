package com.mmh.content.openfeign.fallback;

import com.mmh.content.domain.entity.User;
import com.mmh.content.common.ResponseResult;
import com.mmh.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;



/**
 * @author mingle
 * @date 2022/9/8 9:44
 */
@Slf4j
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService>{
    @Override
    public UserService create(Throwable cause) {
        return id -> {
            log.info("fallback factory method test"+cause);
            User user = User.builder().id(1111).mobile("15262141552").nickname("降级方案返回用户").build();
            return ResponseResult.success(user);
        };
    }
}