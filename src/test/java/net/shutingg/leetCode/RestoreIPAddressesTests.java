package net.shutingg.leetCode;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class RestoreIPAddressesTests {
    private RestoreIPAddresses restoreIPAddresses;

    @Before
    public void setup(){
        restoreIPAddresses = new RestoreIPAddresses();
    }

    @Test
    public void testRestoreIpAddresses(){
        List<String> list = restoreIPAddresses.restoreIpAddresses("25525511135");
        assertEquals(2, list.size());
        assertThat(list, CoreMatchers.hasItem("255.255.11.135"));
        assertThat(list, CoreMatchers.hasItem("255.255.111.35"));

        list = restoreIPAddresses.restoreIpAddresses("0000");
        assertEquals(1, list.size());
        assertThat(list, CoreMatchers.hasItem("0.0.0.0"));

        //no leading zeros
        list = restoreIPAddresses.restoreIpAddresses("010010");
        assertEquals(2, list.size());
        assertThat(list, CoreMatchers.hasItem("0.10.0.10"));
        assertThat(list, CoreMatchers.hasItem("0.100.1.0"));
    }
}
