package net.shutingg.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon OA 2
 */
public class ShotInScene {
    public List<Integer> lengthEachScene(List<Character> inputList) {
        List<Integer> res = new ArrayList<>();
        if (inputList == null || inputList.size() == 0) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int n = inputList.size();
        for (Character c : inputList) {
            map.put(c, i);
            i++;
        }

        int st = 0;
        while (st < n) {
            int end = getLast(st, map, inputList);
            int length = end - st + 1;
            res.add(length);
            st = end + 1;
        }

        return res;
    }

    private int getLast(int st, Map<Character, Integer> map, List<Character> inputList) {
        int n = inputList.size();
        int end = st;
        for (int k = st; k <= end && k <= n - 1; k++) {
            Character c = inputList.get(k);
            if (map.get(c) > end) {
                end = map.get(c);
            }
        }
        return end;
    }
}
