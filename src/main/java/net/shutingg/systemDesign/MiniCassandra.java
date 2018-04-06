package net.shutingg.systemDesign;

import java.util.*;

class Column {
    public int key;
    public String value;

    public Column(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * http://www.lintcode.com/en/problem/mini-cassandra/
 */
public class MiniCassandra {
    private Map<String, NavigableMap<Integer, String>> rowMap;

    public MiniCassandra() {
        rowMap = new HashMap<>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String raw_key, int column_key, String column_value) {
        rowMap.putIfAbsent(raw_key, new TreeMap<>());
        rowMap.get(raw_key).put(column_key, column_value);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        List<Column> list = new ArrayList<>();
        if (!rowMap.containsKey(raw_key)) {
            return list;
        }
        for (Map.Entry<Integer, String> entry : rowMap.get(raw_key).subMap(column_start, true, column_end, true).entrySet()) {
            list.add(new Column(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}
