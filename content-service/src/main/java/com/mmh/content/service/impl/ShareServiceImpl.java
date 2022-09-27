package com.mmh.content.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mmh.content.domain.entity.Share;
import com.mmh.content.repository.ShareRepository;
import com.mmh.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mingle
 * @date 2022/9/6 20:08
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareServiceImpl implements ShareService {
    private final ShareRepository shareRepository;

    @Override
    public Share findById(Integer id) {
        return shareRepository.findById(id).orElse(null);
    }

    @Override
    public List<Share> findAll() {
        return shareRepository.findAll();
    }

    @Override
    @SentinelResource(value = "getNumber",blockHandler = "blockHandlerGetNumber")
    public String getNumber(int number){
        return "number = {" +number +"}";
    }
    @Override
    public  String blockHandlerGetNumber(int number, BlockException e){
        return "BLOCKED";
    }
}