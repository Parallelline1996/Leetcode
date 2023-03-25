/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 23:29
 */

package page9;

import org.junit.Test;
import tools.AssertHelper;
import tools.ListNode;
import tools.ListNodeBuilderHelper;

public class N876_MiddleOfTheLinkedListTest {

    // * Example 1:
    // * Input: head = [1,2,3,4,5]
    // * Output: [3,4,5]

    // * Example 2:
    // * Input: head = [1,2,3,4,5,6]
    // * Output: [4,5,6]

    private N876_MiddleOfTheLinkedList handler = new N876_MiddleOfTheLinkedList();

    @Test
    public void testExample() {
        ListNode input = ListNodeBuilderHelper.buildListNodeList(new int[]{1, 2, 3, 4, 5});
        ListNode output = handler.middleNode(input);
        ListNode exceptOutput = ListNodeBuilderHelper.buildListNodeList(new int[]{3, 4, 5});
        AssertHelper.assertListNodeListEquals(exceptOutput, output);

        input = ListNodeBuilderHelper.buildListNodeList(new int[]{1, 2, 3, 4, 5, 6});
        output = handler.middleNode(input);
        exceptOutput = ListNodeBuilderHelper.buildListNodeList(new int[]{4, 5, 6});
        AssertHelper.assertListNodeListEquals(exceptOutput, output);
    }
}
