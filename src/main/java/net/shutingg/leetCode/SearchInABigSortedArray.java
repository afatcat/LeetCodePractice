package net.shutingg.leetCode;

public class SearchInABigSortedArray {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }

        if (reader.get(0) == target) {
            return 0;
        }
        int end = 1;
        while (reader.get(end) < target) {
            end += end;
        }

        int st = end / 2;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (reader.get(pl) >= target) {
                end = pl;
            } else {
                st = pl;
            }
        }
        if (reader.get(st) == target) {
            return st;
        } else if (reader.get(end) == target) {
            return end;
        } else {
            return -1;
        }
    }

    //dummy class
    class ArrayReader {
        int get(int index) {
            return 0;
        }
    }
}
