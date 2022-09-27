package com.mmh.content.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mmh.content.domain.entity.Share;

import java.util.List;

public interface ShareService {

    /**
     * 根据id查找
     * @param id id
     * @return share
     */
    Share findById(Integer id);

    List<Share> findAll();

    String getNumber(int number);

    String blockHandlerGetNumber(int number, BlockException e);
}
