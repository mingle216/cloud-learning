package com.mmh.content.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.mmh.content.common.ResponseResult;
import com.mmh.content.common.ResultCode;
import com.mmh.content.domain.dto.ShareDto;
import com.mmh.content.domain.entity.Share;
import com.mmh.content.domain.entity.User;
import com.mmh.content.openfeign.UserService;
import com.mmh.content.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lenovo
 */
@Slf4j
@RestController
@RequestMapping(value = "/share")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final UserService userService;

    @GetMapping("all")
    @SentinelResource(value="getAllShares")
    public ResponseResult getAllShares(){
        String result =shareService.getNumber(2022);
        log.info(result);
        if("BLOCKED".equals(result)){
            return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
        }
        return  ResponseResult.success(shareService.findAll());
    }

    @GetMapping("{id}")
    @SentinelResource(value="getShareById")
    public ResponseResult getShareById(@PathVariable Integer id) {
        String result=shareService.getNumber(2025);
        log.info(result);
        if("BLOCKED".equals(result)){
            return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
        }
        Share share = shareService.findById(id);

        Integer userId = share.getUserId();
        ResponseResult res = userService.getUser(userId);
        String jsonString = JSONObject.toJSONString(res.getData());
        JSONObject obj = JSONObject.parseObject(jsonString);
        User user = JSONObject.toJavaObject(obj, User.class);
        ShareDto shareDto = ShareDto.builder().share(share).nickName(user.getNickname()).avatar(user.getAvatar()).build();
        return ResponseResult.success(shareDto);
    }
    public ResponseResult getAllSharesBlock(BlockException exception){
        log.info("接口被限流");
        log.info(exception.toString());
        return ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
    }
}