package net.shutingg.leetCode;

import java.util.*;

public class MinimumSpanningTree {
    class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
        }
     }
    /**
     * DFS
     * Timeout!!
     *
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> res = new ArrayList<>();
        if (connections == null || connections.size() == 0) {
            return res;
        }

        Map<String, List<CityDis>> map = new HashMap<>();
        for (Connection connection : connections) {
            List<CityDis> list = map.get(connection.city1);
            if (list == null) {
                list = new ArrayList<>();
                map.put(connection.city1, list);
            }
            CityDis cd = new CityDis(connection.city2, connection.cost);
            list.add(cd);

            list = map.get(connection.city2);
            if (list == null) {
                list = new ArrayList<>();
                map.put(connection.city2, list);
            }
            cd = new CityDis(connection.city1, connection.cost);
            list.add(cd);
        }

        Result result = new Result();
        for (String city : map.keySet()) {
            Set<String> set = new HashSet<>(map.keySet());
            set.remove(city);
            dfs(map, city, 0, result, new ArrayList<>(), set);
        }
        if (result.list == null) {
            return res;
        }

        return result.list;
    }

    private List<Connection> sortList(List<Connection> list) {
        PriorityQueue<Connection> pq = new PriorityQueue<>(list.size(), (a, b) -> {
            if (a.cost != b.cost) {
                return a.cost - b.cost;
            }
            if (!a.city1.equals(b.city1)) {
                return a.city1.compareTo(b.city1);
            }
            return a.city2.compareTo(b.city2);
        });

        for (Connection c : list) {
            pq.offer(c);
        }
        List<Connection> finalList = new ArrayList<>();
        while (!pq.isEmpty()) {
            finalList.add(pq.poll());
        }

        return finalList;
    }

    private List<Connection> compareList(List<Connection> list1, List<Connection> list2) {
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            Connection c1 = list1.get(i);
            Connection c2 = list2.get(i);
            if (c1.cost < c2.cost) {
                return list1;
            } else if (c1.cost > c2.cost) {
                return list2;
            }
            if (c1.city1.compareTo(c2.city1) < 0) {
                return list1;
            } else if (c1.city1.compareTo(c2.city1) > 0) {
                return list2;
            }
            if (c1.city2.compareTo(c2.city2) < 0) {
                return list1;
            } else if (c1.city2.compareTo(c2.city2) > 0) {
                return list2;
            }
        }
        return list1;
    }

    private void dfs(Map<String, List<CityDis>> map, String current, int sum, Result result, List<Connection> curList, Set<String> cities) {
        if (sum > result.sum) {
            return;
        }
        if (cities.isEmpty()) {
            if (result.list == null || result.sum > sum) {
                result.list = sortList(new ArrayList<>(curList));
                result.sum = sum;
            } else if (result.sum == sum) {
                result.list = compareList(result.list, sortList(new ArrayList<>(curList)));
            }
            return;
        }
        List<CityDis> list = map.get(current);
        for (CityDis cd : list) {
            if (cities.contains(cd.city)) {
                cities.remove(cd.city);
                sum += cd.cost;
                curList.add(construct(current, cd.city, cd.cost));
                dfs(map, cd.city, sum, result, curList, cities);
                curList.remove(curList.size() - 1);
                sum -= cd.cost;
                cities.add(cd.city);
            }
        }
    }

    private Connection construct(String city1, String city2, int cost) {
        if (city1.compareTo(city2) < 0) {
            return new Connection(city1, city2, cost);
        } else {
            return new Connection(city2, city1, cost);
        }
    }

    class Result {
        List<Connection> list;
        Integer sum = Integer.MAX_VALUE;
    }

    class CityDis {
        String city;
        int cost;
        CityDis(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
