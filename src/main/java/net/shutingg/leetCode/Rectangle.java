package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/rectangle/
 */
public class Rectangle {
    /**
     * Hash
     *
     * @param pointSet: The point set
     * @return: The answer
     */
    public String rectangle(Point[] pointSet) {
        if (pointSet == null || pointSet.length == 0) {
            return "NO";
        }

        long range = 100000000;
        Set<Long> hash = new HashSet<>();
        for (Point point : pointSet) {
            hash.add(range * point.x + point.y);
        }

        for (int i = 0; i < pointSet.length; i++) {
            for (int j = 0; j < pointSet.length; j++) {
                if (pointSet[i].x < pointSet[j].x && pointSet[i].y < pointSet[j].y) {
                    if (hash.contains(range * pointSet[j].x + pointSet[i].y) && hash.contains(range * pointSet[i].x + pointSet[j].y)) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }
}
