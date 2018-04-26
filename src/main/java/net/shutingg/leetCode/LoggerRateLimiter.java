package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/logger-rate-limiter/description/
 */
public class LoggerRateLimiter {
    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }

        map.put(message, timestamp);
        return true;
    }
}
