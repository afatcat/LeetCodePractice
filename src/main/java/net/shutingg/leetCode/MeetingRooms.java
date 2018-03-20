package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/description/
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }
}
