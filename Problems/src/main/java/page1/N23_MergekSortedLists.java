/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/12 23:09
 */

package page1;

import tools.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class N23_MergekSortedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        a.next = a1;
        a1.next = a2;
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b.next = b1;
        b1.next = b2;
        ListNode c = new ListNode(2);
        ListNode c1 = new ListNode(6);
        c.next = c1;
        ListNode[] lists = new ListNode[]{a,b,c};
        ListNode result = new N23_MergekSortedLists().mergeKLists(lists);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }

        ListNode result1 = new N23_MergekSortedLists().mergeKLists(new ListNode[]{null});

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode note: lists
             ) {
            if (note != null) {
                queue.add(note);
            }
        }
        ListNode cur = result;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return result.next;
    }
}
