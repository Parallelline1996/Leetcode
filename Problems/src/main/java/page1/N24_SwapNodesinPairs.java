/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/20 23:39
 */

package page1;

import tools.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class N24_SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head, second = head.next;
        ListNode result = new ListNode(0);
        ListNode pre, next;
        result.next = second;
        while (second != null) {
            next = second.next;
            second.next = first;
            first.next = next;
            pre = first;
            if (next == null || next.next == null) {
                break;
            }

            first = next;
            second = first.next;
            pre.next = second;
        }
        return result.next;
    }
}
