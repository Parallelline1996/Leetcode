/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/20 23:07
 */

package page2;


import tools.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 *     You may only use constant extra space.
 *     Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class N116_PopulatingNextRightPointersinEachNode {

    /**
     * a perfect binary tree
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    /**
     * 2ms
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node first = queue.peek();
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                Node temp = queue.poll();
                if (i != 0) {
                    first.next = temp;
                    first = temp;
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return root;
    }
}
