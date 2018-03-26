package net.shutingg.oa;

import java.util.*;
public class UncoveredIntervals {
    public static void main(String args[] ) throws Exception {
        List<Pair> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try{
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strs = line.split(" ");
                int left = Integer.parseInt(strs[0]);
                int right = Integer.parseInt(strs[1]);
                Pair pair = new Pair(left, right);
                list.add(pair);
            }
        } finally {
            scanner.close();
        }

        if (list.size() == 0) {
            return;
        }
        Collections.sort(list, Comparator.comparingInt(i -> i.left));
        Pair pair = list.get(0);
        List<Pair> res = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Pair next = list.get(i);
            if (pair.right < next.left) {
                res.add(pair);
                pair = next;
            } else if (pair.right < next.right) {
                pair.right = next.right;
            }
        }
        res.add(pair);
        if (res.size() <= 1) {
            return;
        }
        List<Pair> negList = new ArrayList<>();
        for (int i = 0; i < res.size() - 1; i++) {
            Pair p = new Pair(res.get(i).right, res.get(i + 1).left);
            negList.add(p);
        }

        for (Pair p : negList) {
            System.out.println(p.left + " " + p.right);
        }
    }


}

class Pair {
    int left;
    int right;
    Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}