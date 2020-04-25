/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/25 0025 11:55
 */

package page7;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels.
 * The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class N662_MaximumWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 将每一次遍历的节点的下标进行保存
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        TreeNode cur = null;
        int num = 0, index = 0, max = 1;
        while (!queue.isEmpty()) {
            num = queue.size();
            for (int i = 0; i < num; i++) {
                cur = queue.poll();
                index = list.getFirst();
                if (cur.left != null) {
                    queue.add(cur.left);
                    list.add(2 * index + 1);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    list.add(2 * index + 2);
                }
                list.remove(0);
            }

            // 通过最左右的两个节点的下标值，来求宽度
            if (!list.isEmpty()) {
                max = Math.max(max, list.get(list.size() - 1) - list.getFirst() + 1);
            }
        }
        return max;
    }
}
