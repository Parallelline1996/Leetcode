/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 22:17
 */

package page3;

import org.junit.Test;
import tools.AssertHelper;
import tools.ListNode;
import tools.ListNodeBuilderHelper;

public class N206_ReverseLinkedListTest {

    private N206_ReverseLinkedList handler = new N206_ReverseLinkedList();

    @Test
    public void testExample() {
        ListNode except = ListNodeBuilderHelper.buildListNodeList(new int[]{5, 4, 3, 2, 1});
        ListNode result = handler.reverseList(ListNodeBuilderHelper.buildListNodeList(new int[]{1, 2, 3, 4, 5}));
        AssertHelper.assertListNodeListEquals(except, result);
    }
}
