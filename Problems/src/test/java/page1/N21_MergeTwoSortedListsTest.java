/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 21:47
 */

package page1;

import org.junit.Test;
import tools.AssertHelper;
import tools.ListNode;
import tools.ListNodeBuilderHelper;

public class N21_MergeTwoSortedListsTest {

    private N21_MergeTwoSortedLists handler = new N21_MergeTwoSortedLists();

    @Test
    public void testExample() {
        ListNode a = ListNodeBuilderHelper.buildListNodeList(new int[]{1, 2, 4});
        ListNode b = ListNodeBuilderHelper.buildListNodeList(new int[]{1, 3, 5, 7});
        ListNode except = ListNodeBuilderHelper.buildListNodeList(new int[]{1, 1, 2, 3, 4, 5, 7});
        ListNode result = handler.mergeTwoLists(a, b);

        AssertHelper.assertListNodeListEquals(except, result);
    }
}
