package ritik.myclassapi.util;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static Logger logger = LoggerFactory.getLogger(Log.class);

    static {
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.DEBUG);
    }

    public static void Error(String tag, String message) {
        logger.error("[" + tag + "] " + message);
    }

    public static void Debug(String tag, String message) {
        logger.debug("[" + tag + "] " + message);
    }

    public static void Info(String tag, String message) {
        logger.info("[" + tag + "] " + message);
    }
}
