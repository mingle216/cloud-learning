package com.mmh.content.service;

import com.mmh.content.domain.entity.Notice;

public interface NoticeService {

    /**
     * 查询最新公告
     * @return notice
     */
    Notice getLatestNotice();
}
