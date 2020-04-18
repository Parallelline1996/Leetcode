/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/18 17:05
 */

package page2;

import tools.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class N108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
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

    public static void main(String[] args) {
        new N108_ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
