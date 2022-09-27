package com.mmh.content.repository;

import com.mmh.content.domain.entity.Notice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NoticeRepository extends JpaRepository<Notice,Integer> {
    /**
     * 根据类型提交查询 根据日期排序
     * @param showFlag showFlag
     * @param sort sort
     * @return list
     */
    List<Notice> findByShowFlag(boolean showFlag, Sort sort);
}
