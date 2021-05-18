package io.qdriven.qaopsdaily.core.annotation;

import io.qdriven.qaopsdaily.core.conf.condition.OnRedisCacheCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnRedisCacheCondition.class)
public @interface ConditionOnRedisCache {
}