package io.qdriven.qaopsdaily.core.conf.condition;

import io.qdriven.qaopsdaily.core.conf.prop.PropKeys;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

public class OnRedisCacheCondition implements Condition {

    @Override
    public boolean matches(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        return Boolean.parseBoolean(context.getEnvironment().getProperty(PropKeys.ENABLE_REDIS_CACHE));
    }
}
