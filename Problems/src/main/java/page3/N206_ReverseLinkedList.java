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

    public static void main(String[] args) {
        ListNode a0 = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode a = new N206_ReverseLinkedList().reverseList(a0);
        while (a != null) {
            System.out.print(a.val + "  ");
            a = a.next;
        }
    }

    /**
     * Iterative, 迭代：一个程序或函数循环迭代多次
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * Recursive, 递归：重复多次调用程序或函数本身
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
