package net.shutingg.oa;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ShotInSceneTests {
    private ShotInScene shotInScene;

    @Before
    public void setup() {
        shotInScene = new ShotInScene();
    }

    @Test
    public void testLengthEachScene() {
        List<Character> inputList = new ArrayList<>();
        inputList.add('a');
        inputList.add('b');
        inputList.add('c');
        inputList.add('a');
        List<Integer> res = shotInScene.lengthEachScene(inputList);
        assertThat(res, is(Arrays.asList(4)));
    }

    @Test
    public void testLengthEachScene2() {
        List<Character> inputList = new ArrayList<>();
        inputList.add('a');
        inputList.add('b');
        inputList.add('c');
        List<Integer> res = shotInScene.lengthEachScene(inputList);
        assertThat(res, is(Arrays.asList(1, 1, 1)));
    }
}
