/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/29 12:09
 */

package page2;

import org.junit.Assert;
import org.junit.Test;

public class N134_GasStationTest {

    @Test
    public void test() {
        Assert.assertEquals(3, new N134_GasStation().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        Assert.assertEquals(-1, new N134_GasStation().canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }
}
