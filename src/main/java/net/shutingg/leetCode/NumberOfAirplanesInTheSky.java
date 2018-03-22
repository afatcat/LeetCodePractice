package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 */
public class NumberOfAirplanesInTheSky {
    /**
     * Sweep line
     *
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }

        List<Point> list = new ArrayList<>();
        for (Interval plane : airplanes) {
            list.add(new Point(plane.start, 1));
            list.add(new Point(plane.end, -1));
        }

        Collections.sort(list, (a, b) -> a.loc != b.loc ? a.loc - b.loc : a.action - b.action);

        int max = 0;
        int count = 0;
        for (Point p : list) {
            count += p.action;
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    class Point {
        int loc;
        int action;

        Point(int loc, int action) {
            this.loc = loc;
            this.action = action;
        }
    }
}
