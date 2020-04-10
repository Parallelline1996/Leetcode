/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 0:20
 */

package page1;

import org.junit.Assert;
import org.junit.Test;

public class N75_SortColorsTest {

    @Test
    public void test() {
        int[] number = new int[]{2,0,2,1,1,0};
        new N75_SortColors().sortColors(number);
        int[] except = new int[]{0,0,1,1,2,2};
        for (int i = 0; i < number.length; i++) {
            Assert.assertEquals(except[i], number[i]);
        }
    }

    @Test
    public void test1() {
        int[] number = new int[]{2,0,1};
        new N75_SortColors().sortColors(number);
        int[] except = new int[]{0,1,2};
        for (int i = 0; i < number.length; i++) {
            Assert.assertEquals(except[i], number[i]);
        }
    }
}
