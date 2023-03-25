/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 22:25
 */

package tools;

import org.junit.Assert;

public class AssertHelper {

    public static void assertListNodeListEquals(ListNode node1, ListNode node2) {
        Assert.assertTrue(CheckHelper.checkListNodeListEquals(node1, node2));
    }

}
