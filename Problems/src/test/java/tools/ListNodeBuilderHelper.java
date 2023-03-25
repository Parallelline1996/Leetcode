/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 22:18
 */

package tools;

public class ListNodeBuilderHelper {

    public static ListNode buildListNodeList(int[] values) {
        ListNode head = new ListNode(0);

        ListNode pre = head;
        for (int value : values) {
            ListNode temp = new ListNode(value);
            pre.next = temp;
            pre = temp;
        }

        return head.next;
    }
}
