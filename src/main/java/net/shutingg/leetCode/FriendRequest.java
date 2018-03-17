package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/friend-request/
 * Given an array Ages of length n, where the first i elements represent the age of the individual i. Find total number of friend requests sent by this n person. There are some requirements:
 1. if Age(B) <= (1/2)Age(A) + 7, A will not send a request to B.
 2. if Age(B) > Age(A), A will not send a request to B.
 3. if Age(B) < 100 and Age(A) > 100, A will not send a request to B.
 4. If it does not satisfy 1,2,3, then A will send a request to B

 Notice

 Ages.length <= 1000。
 Everyone's age is greater than 0, less than 150。
 */
public class FriendRequest {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
        int count = 0;
        if (ages == null || ages.length == 0) {
            return 0;
        }
        for (int i = 0; i < ages.length; i++) {
            for (int j = 0; j < ages.length; j++) {
                if (i == j) {
                    continue;
                }
                if (willRequest(ages[i], ages[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean willRequest(int a, int b) {
        if (b <= a / 2 + 7) {
            return false;
        }
        if (b > a) {
            return false;
        }
        if (b < 100 && a > 100) {
            return false;
        }

        return true;
    }
}
