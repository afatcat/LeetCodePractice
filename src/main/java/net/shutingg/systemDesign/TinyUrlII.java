package net.shutingg.systemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * http://www.lintcode.com/en/problem/tiny-url-ii/
 * System Design
 */
public class TinyUrlII {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private Random rand = new Random();
    public static final String BASE = "http://tiny.url/";
    public static final int KEY_LENGTH = 6;
    /**
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        if (longToShort.containsKey(long_url) && !longToShort.get(long_url).equals(key)) {
            return "error";
        }
        if (shortToLong.containsKey(key) && !shortToLong.get(key).equals(long_url)) {
            return "error";
        }
        String url = BASE + key;
        longToShort.put(long_url, key);
        shortToLong.put(key, long_url);
        return url;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        if (longToShort.containsKey(long_url)) {
            return BASE + longToShort.get(long_url);
        }

        String key = generateRandom(KEY_LENGTH);
        while (shortToLong.containsKey(key)) {
            key = generateRandom(KEY_LENGTH);
        }
        longToShort.put(long_url, key);
        shortToLong.put(key, long_url);
        return BASE + key;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        if (short_url.indexOf(BASE) == -1) {
            return null;
        }
        String key = short_url.replace(BASE, "");
        if (!shortToLong.containsKey(key)) {
            return null;
        }

        return shortToLong.get(key);
    }

    private String generateRandom(int k) {
        String candidates = "ABCDEFGHIJKLMNOPQRSTUVWXYZazcdefghijklmnopqrstuvwxyz0123456789";
        char[] cs = candidates.toCharArray();
        int n = cs.length;
        String result = "";
        for (int i = 0; i < k; i++) {
            result += cs[rand.nextInt(n)];
        }
        return result;
    }
}
