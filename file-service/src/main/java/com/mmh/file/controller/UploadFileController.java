package com.mmh.file.controller;

import com.mmh.file.common.ResponseResult;
import com.mmh.file.common.ResultCode;
import com.mmh.file.utils.FileUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jiangyiheng
 * @date 2022-09-27 22:18
 */
@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @PostMapping("/file")
    public ResponseResult uploadFile(@RequestBody MultipartFile file){
        String url;
        try {
            url = FileUtil.getUrl(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url==null ? ResponseResult.failure(ResultCode.UPLOAD_ERROR) : ResponseResult.success(url);
    }
}