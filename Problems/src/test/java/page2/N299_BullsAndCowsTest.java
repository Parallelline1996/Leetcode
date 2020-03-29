/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/29 0:40
 */

package page2;

import org.junit.Assert;
import org.junit.Test;
import page3.N299_BullsAndCows;

public class N299_BullsAndCowsTest {

    @Test
    public void test() {
        Assert.assertEquals("1A1B", new N299_BullsAndCows().getHint("1123", "0111"));
    }
}
