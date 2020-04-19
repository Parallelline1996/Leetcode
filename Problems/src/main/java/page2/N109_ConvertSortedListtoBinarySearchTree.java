/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/18 17:27
 */

package page2;

import tools.ListNode;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \。
 * -3   9
 * /   /
 * -10  5
 */
public class N109_ConvertSortedListtoBinarySearchTree {


    /**
     * solution 2 :
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return sortedSizedListToBST(head, size);
    }

    private TreeNode sortedSizedListToBST(ListNode head, int size) {
        if (size == 1) {
            return new TreeNode(head.val);
        }
        if (size == 2) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }

        int mid = size / 2;
        ListNode moveNode = head;
        for (int i = 0; i < mid; i++) {
            moveNode = moveNode.next;
        }

        TreeNode root = new TreeNode(moveNode.val);
        root.left = sortedSizedListToBST(head, mid);
        root.right = sortedSizedListToBST(moveNode.next, (size - 1) / 2);
        return root;
    }

    /**
     * solution 1： list -> array
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> lists = new ArrayList<>();
        while (head != null) {
            lists.add(head.val);
            head = head.next;
        }
        Integer[] nums = new Integer[lists.size()];
        lists.toArray(nums);
        return buildTree(nums, 0, lists.size());
    }

    private TreeNode buildTree(Integer[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = buildTree(nums, start, middle - 1);
        treeNode.right = buildTree(nums, middle + 1, end);
        return treeNode;
    }
}
