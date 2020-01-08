package com.springbootuploadfile.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class UploadFileController {
    @Value("${upload.local.path}")
    private String fileTempPath;
    @RequestMapping(value = "/uploadLocal",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Dict uploadFile2Local(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return Dict.create().set("code","400").set("message","文件内容为空");
        }
        String fileName=file.getOriginalFilename();
        String rawFileName= StrUtil.subBefore(fileName,".",true);
        String fileType = StrUtil.subAfter(fileName, ".", true);
        String localFilePath = StrUtil.appendIfMissing(fileTempPath, "/") + rawFileName + "-" + DateUtil.current(false) + "." + fileType;
        if(!new File(fileTempPath).exists()){
            log.info("文件夹不存在，创建");
            new File(fileTempPath).mkdir();
        }
        try {
            file.transferTo(new File(localFilePath));
        } catch (IOException e) {
            log.error("【文件上传至本地】失败，绝对路径：{}", localFilePath);
            return Dict.create().set("code", 500).set("message", "文件上传失败");
        }

        log.info("【文件上传至本地】绝对路径：{}", localFilePath);
        return Dict.create().set("code", 200).set("message", "上传成功").set("data", Dict.create().set("fileName", fileName).set("filePath", localFilePath));

    }

}
