package com.mmh.content.service;

import com.mmh.content.domin.enitiy.Notice;


/**
 * @author jiangyiheng
 * @date 2022-09-06 19:14
 */
public interface NoticeService {

    /**
     * 获取最新的信息,取第一个
     * @return
     */
    Notice getLatestNotice();
}
