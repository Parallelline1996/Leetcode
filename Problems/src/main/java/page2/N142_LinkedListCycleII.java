/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/11 22:35
 */

package page2;

import tools.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class N142_LinkedListCycleII {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode output = new N142_LinkedListCycleII().detectCycle(a);
        if (output == null) {
            System.out.println("null");
        } else {
            System.out.println(output.val);
        }

        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        b.next = c;
        c.next = b;
        ListNode output1 = new N142_LinkedListCycleII().detectCycle(b);
        if (output1 == null) {
            System.out.println("null");
        } else {
            System.out.println(output1.val);
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode output = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (output != slow) {
                    output = output.next;
                    slow = slow.next;
                }
                return output;
            }
        }
        return null;
    }

}
