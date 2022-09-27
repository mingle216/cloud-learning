package com.mmh.content.openfeign.fallback;

import com.mmh.content.common.ResponseResult;
import com.mmh.content.domain.entity.User;
import com.mmh.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mingle
 * @date 2022/9/8 9:15
 */
@Slf4j
@Component
public class UserServiceFallback implements UserService {

    @Override
    public ResponseResult getUser(int id) {
        log.info("fallback getUser");
        User user = User.builder().id(111).mobile("18751852533").nickname("降级方案返回用户").build();
        return ResponseResult.success(user);
    }
}
