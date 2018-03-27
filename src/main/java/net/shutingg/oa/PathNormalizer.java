package net.shutingg.oa;

import java.util.*;

/**
 * I designed a Config class to hold the configuration.
 * The Config class has 2 parameters:
 *  1. endpoint stores endpoint of the config
 *     If endpoint is null, it means there is no corresponding endpoint for the current component.
 *  2. map stores all the children of the config
 *     For /user/friends, user is child of root, friends is child of user.
 *     With a map, the corresponding component can be found in O(1) time.
 * With a path of k components, going through the chain of map takes O(k) time, independent of the number of the endpoints.
 */
public class PathNormalizer {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean inConfig = true;
        Config root = new Config();
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != null && line.length() > 0 && line.charAt(0) == '#') { //config ends
                    inConfig = false;
                    continue;
                }
                if (inConfig) {
                    String[] strs = line.split(" ");
                    String[] paths = strs[0].split("/");
                    if (paths.length == 0) {
                        root.setEndpoint(strs[1]);
                        continue;
                    }
                    Config current = root;
                    for (int i = 1; i < paths.length; i++) {
                        Config config = current.getConfig(paths[i]);
                        if (config == null) {
                            current.setConfig(paths[i], new Config());
                            config = current.getConfig(paths[i]);
                        }
                        current = config;
                    }
                    current.setEndpoint(strs[1]);
                } else {
                    String[] components = line.split("/");
                    if (components.length == 0) {
                        System.out.println(root.getEndpoint() == null ? "404" : root.getEndpoint());
                        continue;
                    }
                    String endpoint = dfs(components, root, 1);
                    System.out.println(endpoint == null ? "404" : endpoint);
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static String dfs(String[] components, Config config, int cur) {
        if (cur == components.length) {
            return config.getEndpoint();
        }
        if (config.contains(components[cur])) {
            Config next = config.getConfig(components[cur]);
            String endpoint = dfs(components, next, cur + 1);
            if (endpoint != null) {
                return endpoint;
            }
        }
        if (config.contains("X")) {
            Config next = config.getConfig("X");
            return dfs(components, next, cur + 1);
        }
        return null;
    }
}

class Config {
    private String endpoint;
    private Map<String, Config> map;

    Config() {
        map = new HashMap<>();
    }

    void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    String getEndpoint() {
        return endpoint;
    }

    Config getConfig(String key) {
        return map.get(key);
    }

    void setConfig(String key, Config config) {
        map.put(key, config);
    }

    boolean contains(String key) {
        return map.containsKey(key);
    }
}

