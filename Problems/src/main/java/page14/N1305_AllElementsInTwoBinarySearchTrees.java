/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 15:56
 */

package page14;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 * Example 1:
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Constraints:
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 *
 */
public class N1305_AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root2, list2);

        List<Integer> list = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) > list2.get(i2)) {
                list.add(list2.get(i2));
                i2++;
            } else {
                list.add(list1.get(i1));
                i1++;
            }
        }

        while (i1 < list1.size()) {
            list.add(list1.get(i1));
            i1++;
        }
        while (i2 < list2.size()) {
            list.add(list2.get(i2));
            i2++;
        }

        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
