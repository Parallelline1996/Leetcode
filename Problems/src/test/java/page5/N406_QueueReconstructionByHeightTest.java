/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/21 22:06
 */

package page5;

import org.junit.Assert;
import org.junit.Test;

public class N406_QueueReconstructionByHeightTest {

    @Test
    public void test() {
        int[][] input = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] output = new N406_QueueReconstructionByHeight().reconstructQueue(input);
        int[][] except = new int[][]{{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(except[i][0], output[i][0]);
            Assert.assertEquals(except[i][1], output[i][1]);
        }
    }
}
