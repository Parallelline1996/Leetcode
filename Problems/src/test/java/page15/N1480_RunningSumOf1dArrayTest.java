/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/19 14:32
 */

package page15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class N1480_RunningSumOf1dArrayTest {


    // * Example 1:
    // * Input: nums = [1,2,3,4]
    // * Output: [1,3,6,10]

    // * Example 2:
    // * Input: nums = [1,1,1,1,1]
    // * Output: [1,2,3,4,5]

    // * Example 3:
    // * Input: nums = [3,1,2,10,1]
    // * Output: [3,4,6,16,17]

    private N1480_RunningSumOf1dArray handler;

    @Before
    public void init() {
        handler = new N1480_RunningSumOf1dArray();
    }

    @Test
    public void testExample() {
        Assert.assertArrayEquals(new int[]{1, 3, 6, 10}, handler.runningSum(new int[]{1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, handler.runningSum(new int[]{1, 1, 1, 1, 1}));
        Assert.assertArrayEquals(new int[]{3, 4, 6, 16, 17}, handler.runningSum(new int[]{3, 1, 2, 10, 1}));
    }
}
