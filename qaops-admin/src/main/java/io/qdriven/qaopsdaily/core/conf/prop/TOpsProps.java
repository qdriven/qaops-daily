package io.qdriven.qaopsdaily.core.conf.prop;

import io.qdriven.qaopsdaily.core.conf.constant.TopsConstant;
import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Patrick
 **/
@Data
@SpringBootConfiguration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = TopsConstant.PROPERTIES_PREFIX)
public class TOpsProps {
    private ShiroProperties shiro = new ShiroProperties();
    private SwaggerProperties swagger = new SwaggerProperties();
    /**
     * 批量插入提交commit数据量
     */
    private int maxBatchInsertNum = 1000;

    private ValidationCodeProperties code = new ValidationCodeProperties();
    /**
     * 是否开启Redis缓存，true开启，false关闭
     * 为false时，采用基于内存的ehcache缓存
     */
    private boolean enableRedisCache;
}
