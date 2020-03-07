/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/7 22:25
 */

package page1;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * Input: 3
 * Output: 5
 * <p>
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class N96_UniqueBinarySearchTrees {

    /**
     * BST tree的特性就是：root的左侧都是比root小的元素，root右侧都是比root大的元素
     * 所以选定root后，左侧都是哪些元素，右侧都是哪些元素都是定了的
     * 这些元素各自组成新的tree，成为root的left和right，而新的tree有多少可直接递归计算
     * 因为左侧的元素是1-root-1,右侧的元素是root+1 - n，也是按照顺序来的
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                int left = root - 1;
                int right = i - root;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
