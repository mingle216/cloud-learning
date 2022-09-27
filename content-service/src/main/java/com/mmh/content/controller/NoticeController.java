package com.mmh.content.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mmh.content.common.ResultCode;
import com.mmh.content.service.NoticeService;
import com.mmh.content.common.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mingle
 * @date 2022/9/6 20:31
 */
@RestController
@RequestMapping(value = "/notice")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeController {
    private final NoticeService noticeService;

    @Value("${disableNoticeRequest:false}")
    private Boolean disableNotice;

    @GetMapping("/latest")
    @SentinelResource(value="getNotice",blockHandler = "getNoticeBlock")
    public ResponseResult getNotice() {
        if(disableNotice){
            System.out.println(disableNotice);
            log.info("暂停公告服务");
            return ResponseResult.failure(ResultCode.INTERFACE_FORBID_VISIT);
        }
        val notice =noticeService.getLatestNotice();
        if(notice != null){
            return ResponseResult.success(notice);
        }else{
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
    public ResponseResult getNoticeBlock(BlockException exception){
        log.info("接口被限流");
        log.info(exception.toString());
        return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
    }
}