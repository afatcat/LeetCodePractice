package net.shutingg.systemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * http://www.lintcode.com/en/problem/tiny-url/
 * System Design
 */
public class TinyUrl {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private Random rand = new Random();
    public static final String BASE = "http://tiny.url/";
    public static final int KEY_LENGTH = 6;

    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        if (longToShort.containsKey(url)) {
            return BASE + longToShort.get(url);
        }

        String key = generateRandom(KEY_LENGTH);
        while (shortToLong.containsKey(key)) {
            key = generateRandom(KEY_LENGTH);
        }
        longToShort.put(url, key);
        shortToLong.put(key, url);
        return BASE + key;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        if (url.indexOf(BASE) == -1) {
            return null;
        }
        String key = url.replace(BASE, "");
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
