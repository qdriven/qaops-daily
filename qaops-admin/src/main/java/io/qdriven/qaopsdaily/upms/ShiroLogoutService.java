package io.qdriven.qaopsdaily.upms;

import io.qdriven.qaopsdaily.core.cache.RedisService;
import io.qdriven.qaopsdaily.core.conf.constant.TopsConstant;
import io.qdriven.qaops.supplement.constant.Strings;
import io.qdriven.qaopsdaily.upms.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.PrincipalCollection;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Slf4j
@Service
public class ShiroLogoutService {

    @Autowired(required = false)
    private RedisService redisService;

    @Async(TopsConstant.SHIRO_THREAD_POOL)
    public void cleanCacheFragment(PrincipalCollection principals) {
        User principal = (User) principals.getPrimaryPrincipal();
        String key = RedisCacheManager.DEFAULT_CACHE_KEY_PREFIX
                + ShiroRealm.class.getName()
                + Strings.DOT + "authenticationCache" + Strings.COLON + principal.getId();
        redisService.del(key);
        log.info("async clean up user cache fragment,cache key: [{}]", key);
    }
}