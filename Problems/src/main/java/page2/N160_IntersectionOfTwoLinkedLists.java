/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/12 22:49
 */

package page2;

import tools.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * Example 2:
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 */
public class N160_IntersectionOfTwoLinkedLists {

    /**
     * The intersection must not be at the beginning of the long chain,
     * move the pointer of the long chain |lenA - lenB| steps forward to change the length of the two chains to the same.
     * Now, intersection at the same position of two chains.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        // long chain move forward
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return headA == headB ? headA : null;
    }


    private int getLength(ListNode node) {
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
