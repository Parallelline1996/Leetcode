/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/12 22:36
 */

package page9;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree,
 * rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * Note:
 *     The number of nodes in the given tree will be between 1 and 100.
 *     Each node will have a unique integer value from 0 to 1000.
 */
public class N897_IncreasingOrderSearchTree {

    /**
     * use inorder travel to get the list
     * use the list to build the tree
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> lists = new ArrayList<>();
        inorderSort(root, lists);
        root = new TreeNode(lists.get(0));
        TreeNode cur = root;
        for (int i = 1; i < lists.size(); i++) {
            cur.right = new TreeNode(lists.get(i));
            cur = cur.right;
        }
        return root;
    }

    private static void inorderSort(TreeNode root, List<Integer> lists) {
        if (root == null) {
            return;
        }
        inorderSort(root.left, lists);
        lists.add(root.val);
        inorderSort(root.right, lists);
    }
}
