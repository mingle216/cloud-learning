package com.mmh.file.utils;

import com.aliyun.oss.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author jiangyiheng
 * @date 2022-09-27 21:51
 */
public class FileUtil {
    /**
     * 保存上传的文件
     *
     * @param file
     * @return 文件下载的url
     * @throws Exception
     */
    public static String saveFile(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            return "";
        }
        File target = new File("file");
        if (!target.isDirectory()) {
            target.mkdirs();
        }
        return getUrl(file);
    }
    //上传阿里云
    public static String getUrl(MultipartFile fileupload) throws OSSException, ClientException, IOException {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tF5kv979HVLD73A8Djc";
        String accessKeySecret = "HNVTLD9lpxHCC00pbamJLKsDid3Uqg";
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 文件桶
        String bucketName = "wx-login";
        // 文件名格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String oldName = fileupload.getOriginalFilename();
        System.out.println("oldName = " + oldName);
        String newName = UUID.randomUUID().toString() + oldName.
                substring(oldName.lastIndexOf("."), oldName.length());
        System.out.println("newName = " + newName);
        // 该桶中的文件key
//        String dateString = sdf.format(new Date()) + ".jpg";
        // 上传文件
        ossClient.putObject(bucketName, newName, new ByteArrayInputStream(fileupload.getBytes()));

        // 设置URL过期时间为100年，默认这里是int型，转换为long型即可
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, newName, expiration);
        ossClient.shutdown();
        return url.toString();
    }
}