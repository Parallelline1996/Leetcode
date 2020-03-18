/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/18 22:33
 */

package page2;

import org.junit.Assert;
import org.junit.Test;

public class N198_HouseRobberTest {

    /**
     *  * Input: [1,2,3,1]
     *  * Output: 4
     *  * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *  *              Total amount you can rob = 1 + 3 = 4.
     *  *
     *  * Example 2:
     *  * Input: [2,7,9,3,1]
     *  * Output: 12
     */

    @Test
    public void test() {
        Assert.assertEquals(4, new N198_HouseRobber().rob(new int[]{1,2,3,1}));
        Assert.assertEquals(12, new N198_HouseRobber().rob(new int[]{2,7,9,3,1}));
        Assert.assertEquals(1, new N198_HouseRobber().rob(new int[]{1}));
        Assert.assertEquals(7, new N198_HouseRobber().rob(new int[]{2,7}));
        Assert.assertEquals(7, new N198_HouseRobber().rob(new int[]{2,7,2}));
    }
}
