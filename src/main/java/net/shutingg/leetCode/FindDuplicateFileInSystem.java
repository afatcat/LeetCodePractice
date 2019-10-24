package net.shutingg.leetCode;

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return result;
        }

        Map<String, List<String>> contentToPath = new HashMap<>();
        for (String path: paths) {
            String[] parts = path.split("\\s");
            String directory = parts[0];
            System.out.println("directory " + directory);
            for (int i = 1; i < parts.length; i++) {
                String fileName = parts[i].substring(0, parts[i].indexOf('('));
                String content = parts[i].substring(parts[i].indexOf('(') + 1, parts[i].length() - 1);
                if (!contentToPath.containsKey(content)) {
                    contentToPath.put(content, new ArrayList<>());
                }
                contentToPath.get(content).add(directory + "/" + fileName);
            }
        }

        for (String content: contentToPath.keySet()) {
            if (contentToPath.get(content).size() > 1) {
                result.add(contentToPath.get(content));
            }
        }

        return result;
    }
}
