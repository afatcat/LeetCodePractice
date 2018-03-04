package net.shutingg.oa;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NineteenPercentile {
//    public static void main(String args[] ) throws Exception {
//        ZonedDateTime time1 = getLocalTime("962668800");
//        ZonedDateTime time2 = getLocalTime("962668810");
//        ZonedDateTime time3 = getLocalTime("962668860");
//
//        System.out.println(timeStampFormat(time1));
//        System.out.println(timeStampFormat(time2));
//        System.out.println(timeStampFormat(time3));
//        isAtMinute(time1);
//        isAtMinute(time2);
//        isAtMinute(time3);
//
//        System.out.println(timeStampAtMin(time1));
//        System.out.println(timeStampAtMin(time2));
//        System.out.println(timeStampAtMin(time3));
//    }

    static Double[] cache = new Double[1000];
    static int pl = 0;
    static String recordTime = "";
    static Random rand = new Random();

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.next();

        ZonedDateTime zonedDateTime = getLocalTime(args[0]);
        double duration = Double.valueOf(args[1]);
        if (isAtMinute(zonedDateTime)) {
            double sec = generateTime();
            System.out.println(recordTime + " "+ sec);
            refreshCache(zonedDateTime);
        }
        insertTime(duration);
    }

    private static boolean isAtMinute(ZonedDateTime zonedDateTime) {
        if (zonedDateTime.getSecond() == 0) {
            if (recordTime.equals(timeStampAtMin(zonedDateTime))) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private static String timeStampFormat(ZonedDateTime zonedDateTime){
        return zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
    }

    private static ZonedDateTime getLocalTime(String timestamp) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(Long.valueOf(timestamp)), ZoneId.of("GMT-0"));
    }

    private static String timeStampAtMin(ZonedDateTime zonedDateTime) {
        return zonedDateTime.withSecond(0).format(DateTimeFormatter.ISO_INSTANT);
    }

    private static void insertTime(double t) {
        if (t < 0 || t > 150) {
            return;
        }
        if (pl < cache.length) {
            cache[pl] = t;
        } else {
            int p = rand.nextInt(1000);
            cache[p] = t;
        }
    }

    private static double generateTime() {
        Arrays.sort(cache, (a, b) -> {
            if (a == null && b == null) {
                return 0;
            }
            if (a == null) {
                return 1;
            }
            if (b == null) {
                return -1;
            }
            return b.compareTo(a);
        });
        int p = (int) Math.floor( pl * 0.1);
        return cache[p];
    }

    private static void refreshCache(ZonedDateTime zonedDateTime) {
        cache = new Double[1000];
        pl = 0;
        recordTime = timeStampAtMin(zonedDateTime);
    }
}
