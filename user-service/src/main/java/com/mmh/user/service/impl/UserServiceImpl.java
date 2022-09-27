package com.mmh.user.service.impl;

import com.mmh.user.domain.dto.UserDto;
import com.mmh.user.domain.enitiy.User;
import com.mmh.user.repository.UserRepository;
import com.mmh.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mingle
 * @date 2022/9/6 17:22
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User login(UserDto userDto) {
        return userRepository.findByMobileAndPassword(userDto.getMobile(),userDto.getPassword());
    }
}
