package me.fliqq.logfilter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;

import java.util.List;

public class LogFilter implements Filter {

    private final List<String> filter;

    public LogFilter(List<String> filter) {
        this.filter = filter;
    }

    private Filter.Result checkMessage(String message) {
        for (String s : filter) {
            if (message.contains(s))
                return Filter.Result.DENY;
        }
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result filter(LogEvent event) {
        return checkMessage(event.getMessage().getFormattedMessage());
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object... params) {
        return checkMessage(message);
    }

    @Override
    public LifeCycle.State getState() {
        return LifeCycle.State.STARTED;
    }

    @Override
    public void initialize() {}

    @Override
    public boolean isStarted() {
        return true;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public Filter.Result getOnMatch() {
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result getOnMismatch() {
        return Filter.Result.NEUTRAL;
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4,
                                Object p5) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4,
                                Object p5, Object p6) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4,
                                Object p5, Object p6, Object p7) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4,
                                Object p5, Object p6, Object p7, Object p8) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4,
                                Object p5, Object p6, Object p7, Object p8, Object p9) {
        return checkMessage(message);
    }

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        String message = msg != null ? msg.toString() : "";
        return checkMessage(message);
    }
    

    @Override
    public Filter.Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        String message = msg != null ? msg.getFormattedMessage() : "";
        return checkMessage(message);
    }
}
