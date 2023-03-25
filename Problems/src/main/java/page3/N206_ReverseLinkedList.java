/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/17 22:24
 */

package page3;

import tools.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class N206_ReverseLinkedList {

    /**
     * Iterative, 迭代：一个程序或函数循环迭代多次
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = null;
        ListNode next = head;
        while (next != null) {
            // cur指针指向要处理节点
            cur = next;
            // next指针移动到下一个要处理的节点
            next = next.next;
            // cur节点的方向指向之前的节点，完成反转
            cur.next = pre;
            // pre指向现在的节点，对于下一个节点的处理，pre为当前节点
            pre = cur;
        }
        return cur;
    }

    /**
     * Recursive, 递归：重复多次调用程序或函数本身
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
