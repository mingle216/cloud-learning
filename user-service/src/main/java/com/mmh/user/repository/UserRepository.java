package com.mmh.user.repository;

import com.mmh.user.domain.enitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiangyiheng
 * @date 2022-09-06 16:24
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 根据用户名密码查询
     * @param mobile mobile
     * @param password password
     * @return user
     */
    User findByMobileAndPassword(String mobile,String password);
}
