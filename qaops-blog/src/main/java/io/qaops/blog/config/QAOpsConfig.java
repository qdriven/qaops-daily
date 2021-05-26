package io.qaops.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QAOpsConfig {

    @Value("${qaops.uploadFolde:/opt/qablog/upload/}")
    public String FILE_UPLOAD_DIC;//上传文件的默认url前缀，根据部署设置自行修改
}