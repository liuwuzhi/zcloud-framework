package org.zcloud.framework.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class LoggingTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    public void test01(){
        long start = System.nanoTime();
        for(int i=1; i<5; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 1; j < 5; j++) {
                    MDC.put("threadId", UUID.randomUUID().toString());
                    new TxFlow().run();
                }
            }).start();
        }
        long end = System.nanoTime();
        LOGGER.info("exec time is {}s == {}ms == {}μs == {}ns", (end-start)/1000000000/60, (end-start)/1000000000,  (end-start)/1000, end-start);
    }
}
