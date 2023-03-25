package page8;

import org.junit.Test;

import static org.junit.Assert.*;

public class N704_BinarySearchTest {

    // * Example 1:
    // * Input: nums = [-1,0,3,5,9,12], target = 9
    // * Output: 4

    // * Example 2:
    // * Input: nums = [-1,0,3,5,9,12], target = 2
    // * Output: -1
    // * Explanation: 2 does not exist in nums so return -1

    private N704_BinarySearch handler = new N704_BinarySearch();

    @Test
    public void testExample() {
        assertEquals(4, handler.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, handler.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}