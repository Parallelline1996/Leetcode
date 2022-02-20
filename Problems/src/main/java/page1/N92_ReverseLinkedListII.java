/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2021/7/4 22:38
 */

package page1;

import tools.ListNode;

public class N92_ReverseLinkedListII {

    /**
     * 方法一：
     */
    public ListNode reverseBetween0(ListNode head, int left, int right) {
        // 快速返回
        if (head == null || head.next == null) {
            return head;
        }

        // 哨兵节点
        ListNode start = new ListNode(0);
        start.next = head;
        int num = 1;

        // 第一部分(正序)的最后一个节点
        ListNode endOfFirstPart = start;
        for (; num < left; num++) {
            endOfFirstPart = endOfFirstPart.next;
        }

        // 第二部分(逆序)的最后一个节点
        ListNode endOfSecondPart = endOfFirstPart;
        for (; num <= right; num++) {
            endOfSecondPart = endOfSecondPart.next;
        }

        // 记录第三部分(正序)的起始一个节点
        ListNode startOfThirdPart = endOfSecondPart.next;

        // 处理第二部分(逆序)
        endOfSecondPart.next = null;
        ListNode reverseListStart = reverseList(endOfFirstPart.next);

        // 将三部分进行组装
        endOfFirstPart.next.next = startOfThirdPart;
        endOfFirstPart.next = reverseListStart;
        return start.next;
    }

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode pre = null;
        ListNode cur = null;
        ListNode next = node;
        while (next != null) {
            cur = next;
            next = next.next;
            cur.next = pre;
            pre = cur;

        }
        return cur;
    }

    /**
     * 方法二：
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}
