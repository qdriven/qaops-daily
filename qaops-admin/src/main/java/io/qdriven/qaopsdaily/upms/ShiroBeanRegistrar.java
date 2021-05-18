package io.qdriven.qaopsdaily.upms;

import cn.hutool.core.util.StrUtil;
import io.qdriven.qaopsdaily.core.conf.constant.TopsConstant;
import io.qdriven.qaops.supplement.constant.Strings;
import io.qdriven.qaopsdaily.core.conf.prop.ShiroProperties;
import io.qdriven.qaopsdaily.core.conf.prop.TOpsProps;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * <p>
 * https://github.com/spring-projects/spring-boot/issues/16097
 * https://issues.apache.org/jira/browse/SHIRO-743
 *
 */
@Configuration(proxyBeanMethods = false)
public class ShiroBeanRegistrar {

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Lazy DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Lazy DefaultWebSecurityManager securityManager,
                                                         @Lazy TOpsProps tOpsProps) {
        ShiroProperties shiro = tOpsProps.getShiro();
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录的 url
        shiroFilterFactoryBean.setLoginUrl(shiro.getLoginUrl());
        // 登录成功后跳转的 url
        shiroFilterFactoryBean.setSuccessUrl(shiro.getSuccessUrl());
        // 未授权 url
        shiroFilterFactoryBean.setUnauthorizedUrl(shiro.getUnauthorizedUrl());
        // 设置免认证 url
        LinkedHashMap<String, String> filterChainDefinitionMap;
        String[] anonUrls = StrUtil.split(shiro.getAnonUrl(),Strings.COMMA);
//                StringUtils.splitByWholeSeparatorPreserveAllTokens(shiro.getAnonUrl(), Strings.COMMA);
        filterChainDefinitionMap = Arrays.stream(anonUrls).collect(Collectors.toMap(url -> url, url -> "anon", (a, b) -> b, LinkedHashMap::new));
        // 配置退出过滤器，其中具体的退出代码 Shiro已经替我们实现了
        filterChainDefinitionMap.put(shiro.getLogoutUrl(), "logout");
        // 除上以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterChainDefinitionMap.put(TopsConstant.REQUEST_ALL, "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
