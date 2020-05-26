/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/26 23:27
 */

package page1;

/**
 * https://leetcode.com/problems/interleaving-string/submissions/
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class N97_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            dp[i][0] = true;
        }

        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                helper(dp, i, j, s1, s2, s3);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public void helper(boolean[][] dp, int i, int j, String s1, String s2, String s3) {
        dp[i][j] = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) ||
                dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println(new N97_InterleavingString().isInterleave("a", "", "aa"));
    }
}
