package test.ossw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    static Logger logger1 = LoggerFactory.getLogger("user");

    static Logger logger2 = LoggerFactory.getLogger("artwork");

    public static void main(String[] args) {
        logger.info("hello");
        logger.info("test {} what {} is {}",1,2,2);
        logger1.info("hello");
        logger2.info("hello");
    }
}
