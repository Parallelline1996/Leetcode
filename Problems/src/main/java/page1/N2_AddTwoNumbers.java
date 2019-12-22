/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/7 19:06
 */

package page1;

import tools.ListNode;

/**
* 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
* 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
*
* 思路：类比N67的两数相加
*
* Example:
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
* */
public class N2_AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        // add 表示是否进位
        int add = 0, a1, a2;
        while (l1 != null || l2 != null) {
            // 这里用的处理方法是，当一条链结束时，接下来的循环中，该链获取的值均为 0
            // 直到两条链均遍历完时，再结束循环
            if (l1 != null) {
                a1 = l1.val;
                l1 = l1.next;
            } else {
                a1 = 0;
            }

            if (l2 != null) {
                a2 = l2.val;
                l2 = l2.next;
            } else {
                a2 = 0;
            }
            head.next = new ListNode((a1 + a2 + add) % 10);
            add = (a1 + a2 + add) / 10;
            head = head.next;
        }
        // 对进位的参数进行判断，判断是否需要进位
        if (add == 1) {
            head.next = new ListNode(1);
        }

        return result.next;
    }

    /**
     * 简单测试
     * @param args
     */
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(4);
        a.next = a1;
        a1.next = a2;
        b.next = b1;
        b1.next = b2;
        ListNode c = addTwoNumbers(a, b);
        while (c != null) {
            System.out.print(c.val + "  ");
            c = c.next;
        }
        System.out.println("\n=======");
        ListNode d = new ListNode(5);
        ListNode d1 = new ListNode(5);
        ListNode e = addTwoNumbers(d, d1);
        while (e != null) {
            System.out.print(e.val + "  ");
            e = e.next;
        }
        System.out.println();
    }

    /**
     * 比较差的做法，因为没有使用哨兵，多了一步判断
     */
    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode output = null;
        ListNode head = null;
        head.next = output;
        int a, b, add = 0, total;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            total = a + b + add;
            add = total / 10;
            // 这里没有采用哨兵的作法，因此导致需要多一步判断
            if (output == null) {
                output = new ListNode(total % 10);
                head = output;
            } else {
                output.next = new ListNode(total % 10);
                output = output.next;
            }
        }
        if (add == 1) {
            output.next = new ListNode(add);
        }
        return head;
    }

}

