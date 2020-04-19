/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/19 15:27
 */

package page2;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Example:
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 * Note:
 *     next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *     You may assume that next() call will always be valid, that is,
 *     there will be at least a next smallest number in the BST when next() is called.
 */
public class N173_BinarySearchTreeIterator {

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    class BSTIterator {

        List<Integer> list = new ArrayList<>();
        int index = 0;

        public BSTIterator(TreeNode root) {
            inorder(root);
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(index++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < list.size();
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

}
