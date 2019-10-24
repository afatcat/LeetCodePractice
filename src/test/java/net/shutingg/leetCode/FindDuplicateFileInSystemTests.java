package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FindDuplicateFileInSystemTests {
    private FindDuplicateFileInSystem findDuplicateFileInSystem;

    @Before
    public void setup() {
        findDuplicateFileInSystem = new FindDuplicateFileInSystem();
    }

    @Test
    public void test1() {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        List<List<String>> result = findDuplicateFileInSystem.findDuplicate(paths);
        for (List<String> list: result) {
            for (String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
