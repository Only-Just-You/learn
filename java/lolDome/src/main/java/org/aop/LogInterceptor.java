package org.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    public void before(){
        logger.info("login start!");
    }
    public void after(){
        logger.info("login end!");
    }
    public void afterError(){
        logger.error("表演失败，遭到了唾弃！！！");
    }
}
