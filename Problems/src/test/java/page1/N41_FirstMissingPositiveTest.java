/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/29 0:03
 */

package page1;

import org.junit.Assert;
import org.junit.Test;

public class N41_FirstMissingPositiveTest {

    @Test
    public void test() {
        Assert.assertEquals(3, new N41_FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));
        Assert.assertEquals(2, new N41_FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assert.assertEquals(1, new N41_FirstMissingPositive().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
