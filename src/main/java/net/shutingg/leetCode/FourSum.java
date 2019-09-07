package net.shutingg.leetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class FourSum {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(numbers[i], numbers[j], numbers[left], numbers[right]);
                        result.add(list);
                        while (left + 1 < right && numbers[left] == numbers[left + 1]) {
                            left++;
                        }
                        while (left + 1 < right && numbers[right] == numbers[right - 1]) {
                            right--;
                        }
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    //HashMap solution timeout
//    /**
//     * @param numbers: Give an array
//     * @param target: An integer
//     * @return: Find all unique quadruplets in the array which gives the sum of zero
//     */
//    public List<List<Integer>> fourSum(int[] numbers, int target) {
//        // write your code here
//        if (numbers == null || numbers.length < 4) {
//            return new ArrayList<>();
//        }
//
//        Arrays.sort(numbers);
//        Map<Integer, List<List<Integer>>> map = new HashMap<>();
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                int sum = numbers[i] + numbers[j];
//                List<List<Integer>> list = map.getOrDefault(sum, new ArrayList<>());
//                list.add(Arrays.asList(i, j));
//                map.put(sum, list);
//            }
//        }
//
//        int left = 0;
//        int right = numbers.length - 1;
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                int key = target - numbers[i] - numbers[j];
//                if (map.containsKey(key)) {
//                    List<List<Integer>> list1 = map.get(key);
//                    for(List<Integer> tmp: list1) {
//                        if (!tmp.contains(i) && !tmp.contains(j)) {
//                            List<Integer> aList = new ArrayList<>();
//                            aList.add(numbers[tmp.get(0)]);
//                            aList.add(numbers[tmp.get(1)]);
//                            aList.add(numbers[i]);
//                            aList.add(numbers[j]);
//                            aList.sort((Integer i1, Integer i2) -> i1 - i2);
//                            if (!containsList(result, aList)) {
//                                result.add(aList);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean containsList(List<List<Integer>> lists, List<Integer> list) {
//        for (List<Integer> l: lists) {
//            if (deepEquals(l, list)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean deepEquals(List<Integer> list1, List<Integer> list2) {
//        if (list1.size() != list2.size()) {
//            System.out.printf("size not equals %d, %d", list1.size(), list2.size());
//            return false;
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            if (!list1.get(i).equals(list2.get(i))) {
//                System.out.printf("place at %d not equals %d, %d", i, list1.get(i), list2.get(i));
//                return false;
//            }
//        }
//        return true;
//    }
}
