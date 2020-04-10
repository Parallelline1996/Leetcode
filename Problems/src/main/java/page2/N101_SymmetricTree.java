/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 0:23
 */

package page2;

import tools.TreeNode;

import java.util.Objects;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *   1
 *  / \
 * 2   2
 * \    \
 *  3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 */
public class N101_SymmetricTree {

    private StringBuilder inorder = new StringBuilder();
    private StringBuilder inverseInorder = new StringBuilder();

    public static void main(String[] args) {
        //     1
        //   / \
        //  2   2
        // / \ / \
        //3  4 4  3
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        System.out.println(new N101_SymmetricTree().isSymmetric(a1));

        //     1
        //   / \
        //  2   2
        // /   /
        //2    2
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(2);
        TreeNode b4 = new TreeNode(2);
        TreeNode b5 = new TreeNode(2);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b3.left = b5;
        System.out.println(new N101_SymmetricTree().isSymmetric(b1));
    }

    /**
     * method one：traverse completely, than record
     */
    public boolean isSymmetric(TreeNode root) {
        inorderTraversal(root, 0);
        inverseInorderTraversal(root, 0);
        return Objects.equals(inorder.toString(), inverseInorder.toString());
    }

    private void inorderTraversal(TreeNode root, int i) {
        if (root == null) {
            inorder.append(i);
            return;
        }
        inorderTraversal(root.left, i + 1);
        inorder.append(root.val).append(i);
        inorderTraversal(root.right, i + 1);
    }

    private void inverseInorderTraversal(TreeNode root, int i) {
        if (root == null) {
            inverseInorder.append(i);
            return;
        }
        inverseInorderTraversal(root.right, i + 1);
        inverseInorder.append(root.val).append(i);
        inverseInorderTraversal(root.left, i + 1);
    }

    /**
     * method two： more quick， do not need to traverse it completely twice
     */
    public boolean isSymmetric1(TreeNode root) {
        return isSymmetric(root, root);
    }

    /**
     * N100_SameTree
     */
    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null | root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
