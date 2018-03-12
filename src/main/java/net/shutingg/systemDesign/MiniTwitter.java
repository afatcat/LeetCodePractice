package net.shutingg.systemDesign;

import java.util.*;

class Tweet {
    public int id;
    public int user_id;
    public String text;
    static int seq;
    public static Tweet create(int user_id, String tweet_text) {
        int id = seq;
        seq++;
        Tweet tweet = new Tweet(id, user_id, tweet_text);
        return tweet;
    }

    private Tweet(int id, int user_id, String tweet_text) {
        this.id = id;
        this.user_id = user_id;
        this.text = tweet_text;
    }
}

/**
 * http://www.lintcode.com/en/problem/mini-twitter/
 *
 * Implemented with pull model
 */
public class MiniTwitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<UserTweet>> userTweetMap;
    long startTime;

    public MiniTwitter() {
        followMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        startTime = System.nanoTime();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        userTweetMap.putIfAbsent(user_id, new ArrayList<>());
        List<UserTweet> list = userTweetMap.get(user_id);
        UserTweet userTweet = new UserTweet(tweet);
        list.add(userTweet);

        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        Set<Integer> friends = followMap.get(user_id);
        List<UserTweet> combinedList = new ArrayList<>();
        if (friends != null) {
            for (int friendId : friends) {
                List<UserTweet> list = getLastTen(userTweetMap.getOrDefault(friendId, new ArrayList<>()));
                combinedList.addAll(list);
            }
        }
        List<UserTweet> userList = getLastTen(userTweetMap.getOrDefault(user_id, new ArrayList<>()));
        combinedList.addAll(userList);
        Collections.sort(combinedList, (a, b) -> b.createTime.compareTo(a.createTime));
        List<Tweet> result = new ArrayList<>();
        for (int i = 0; i < 10 && i < combinedList.size(); i++) {
            result.add(combinedList.get(i).tweet);
        }
        return result;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        List<UserTweet> list = userTweetMap.get(user_id);
        List<Tweet> res = new ArrayList<>();
        if(list == null) {
            return res;
        }
        for (int i = list.size() - 1; i >=0 && i >= list.size() - 10; i--) {
            res.add(list.get(i).tweet);
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        followMap.putIfAbsent(from_user_id, new HashSet<>());
        followMap.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        Set<Integer> set = followMap.get(from_user_id);
        if (set != null) {
            set.remove(to_user_id);
        }
    }

    private List<UserTweet> getLastTen(List<UserTweet> list) {
        int size = list.size() >= 10 ? 10 : list.size();
        return list.subList(list.size() - size, list.size());
    }

    class UserTweet {
        Long createTime;
        Tweet tweet;

        UserTweet(Tweet tweet) {
            createTime = System.nanoTime() - startTime;
            this.tweet = tweet;
        }
    }
}