/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/7 21:06
 */

package page6;

import tools.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * <p>
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * <p>
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
public class N589_N_aryTreePreorderTraversal {

    /**
     * recursion
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> list, Node root) {
        list.add(root.val);
        for (Node node : root.children) {
            helper(list, node);
        }
    }

    /**
     * non-recursive
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp.val);

            // 从后往前加
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.add(temp.children.get(i));
            }
        }

        return result;
    }
}
