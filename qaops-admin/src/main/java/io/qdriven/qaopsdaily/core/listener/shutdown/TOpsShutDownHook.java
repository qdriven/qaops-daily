package io.qdriven.qaopsdaily.core.listener.shutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TOpsShutDownHook {

    @EventListener(classes = {ContextClosedEvent.class})
    public void onFebsApplicationClosed(@NonNull ApplicationEvent event) {
        log.info("event getting from springboot is {}",event.getSource().toString());
        log.info("start to shutdown Test Ops  application");
    }
}