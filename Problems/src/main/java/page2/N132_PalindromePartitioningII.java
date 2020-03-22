/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/22 16:11
 */

package page2;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class N132_PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(new N132_PalindromePartitioningII().minCut("aab"));
        System.out.println(new N132_PalindromePartitioningII().minCut("kkk"));
        System.out.println(new N132_PalindromePartitioningII().minCut("abbbaa"));
    }

    /**
     * 8ms 78.68%
     */
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] num = new int[s.length()];

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (chars[j] == chars[i] && (j + 1 >= i || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, num[j - 1] + 1);
                }
            }
            num[i] = min;
        }

        return num[s.length() - 1];
    }
}
