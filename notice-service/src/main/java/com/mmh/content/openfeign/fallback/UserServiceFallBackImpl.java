package com.mmh.content.openfeign.fallback;

import com.mmh.content.common.ResponseResult;
import com.mmh.content.domin.enitiy.User;
import com.mmh.content.openfeign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jiangyiheng
 * @date 2022-09-08 9:03
 */
@Slf4j
@Component
public class UserServiceFallBackImpl implements UserService {
    @Override
    public ResponseResult getUser(int id) {
        log.info("fallback getUser");
        User user = new User();
        user.setNickname("降级方案返回用户");
        return ResponseResult.success(user);
    }
}
