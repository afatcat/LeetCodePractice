package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII_2Tests {
    private WordLadderII_2 wordLadderII_2;
    @Before
    public void setup() {
        wordLadderII_2 = new WordLadderII_2();
    }

    @Test
    public void test1() {
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        List<List<String>> result = wordLadderII_2.findLadders("hit", "cog", dict);
        System.out.println(result);
    }
}
