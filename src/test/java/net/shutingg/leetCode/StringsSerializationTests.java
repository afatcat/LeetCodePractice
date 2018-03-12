package net.shutingg.leetCode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringsSerializationTests {
    private StringsSerialization stringsSerialization;

    @Before
    public void setup() {
        stringsSerialization = new StringsSerialization();
    }

    @Test
    public void testEncode() {
        List<String> input = new ArrayList<>();
        input.add("lint");
        input.add("cod:e");
        input.add("lov:;e");
        input.add("you");

        String result = stringsSerialization.encode(input);
        assertEquals("lint:;cod::e:;lov::;e:;you", result);
    }

    @Test
    public void testEncodeAndDecode() {
        List<String> input = new ArrayList<>();
        input.add("lint");
        input.add("cod:e");
        input.add("lov:;e");
        input.add("you");

        String encoded = stringsSerialization.encode(input);
        List<String> decoded = stringsSerialization.decode(encoded);
        assertThat(decoded, is(input));
    }
}
