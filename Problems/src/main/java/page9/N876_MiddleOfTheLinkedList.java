/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/22 23:26
 */

package page9;

import tools.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class N876_MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 考虑输入为奇数或偶数
        return fast.next == null ? slow : slow.next;
    }
}
