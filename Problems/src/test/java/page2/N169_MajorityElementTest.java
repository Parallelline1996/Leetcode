package page2;

import org.junit.Test;

import static org.junit.Assert.*;

public class N169_MajorityElementTest {

    private N169_MajorityElement handler = new N169_MajorityElement();

    @Test
    public void test() {
        // * Example 1:
        // * Input: [3,2,3]
        // * Output: 3
        assertEquals(3, handler.majorityElement(new int[]{3, 2, 3}));

        // * Example 2:
        // * Input: [2,2,1,1,1,2,2]
        // * Output: 2
        assertEquals(2, handler.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}