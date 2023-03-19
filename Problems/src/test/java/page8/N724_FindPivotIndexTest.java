/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/19 14:57
 */

package page8;

import org.junit.Assert;
import org.junit.Test;

public class N724_FindPivotIndexTest {

    // * Example 1:
    // * Input: nums = [1,7,3,6,5,6]
    // * Output: 3

    // * Example 2:
    // * Input: nums = [1,2,3]
    // * Output: -1

    // * Example 3:
    // * Input: nums = [2,1,-1]
    // * Output: 0

    private N724_FindPivotIndex handler = new N724_FindPivotIndex();

    @Test
    public void testExample() {
        Assert.assertEquals(3, handler.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        Assert.assertEquals(-1, handler.pivotIndex(new int[]{1, 2, 3}));
        Assert.assertEquals(0, handler.pivotIndex(new int[]{2, 1, -1}));
    }
}
