package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedIntervalLists {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> results = new ArrayList<>();
        if (list1 == null && list2 == null) {
            return results;
        }
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        Interval current;
        int i = 0;
        int j = 0;
        if (list1.get(0).start < list2.get(0).start) {
            current = list1.get(0);
            i = 1;
        } else {
            current = list2.get(0);
            j = 1;
        }

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                if (current.end < list1.get(i).start) {
                    results.add(current);
                    current = list1.get(i);
                    i++;
                } else {
                    current.end = current.end > list1.get(i).end ? current.end : list1.get(i).end;
                    i++;
                }
            } else {
                if (current.end < list2.get(j).start) {
                    results.add(current);
                    current = list2.get(j);
                    j++;
                } else {
                    current.end = current.end > list2.get(j).end ? current.end : list2.get(j).end;
                    j++;
                }
            }
        }
        while (i < list1.size()) {
            if (current.end < list1.get(i).start) {
                results.add(current);
                current = list1.get(i);
            } else {
                current.end = current.end > list1.get(i).end ? current.end : list1.get(i).end;
            }
            i++;
        }
        while (j < list2.size()) {
            if (current.end < list2.get(j).start) {
                results.add(current);
                current = list2.get(j);
            } else {
                current.end = current.end > list2.get(j).end ? current.end : list2.get(j).end;
            }
            j++;
        }
        results.add(current);

        return results;
    }
}
