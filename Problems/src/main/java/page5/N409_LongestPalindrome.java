/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/3/25 10:49
 */

package page5;

/**
 * https://leetcode.com/problems/longest-palindrome
 * <p>
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 * <p>
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
public class N409_LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() < 2) {
            return s.length();
        }

        int[] lowercases = new int[26];
        int[] uppercases = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] > 'Z') {
                uppercases[chars[i] - 'a']++;
            } else {
                lowercases[chars[i] - 'A']++;
            }
        }

        int num = 0;
        boolean hasOdd = false;
        for (int lowercase : lowercases) {
            num += lowercase / 2;
            if (!hasOdd) {
                hasOdd = (lowercase % 2 != 0);
            }
        }

        for (int uppercase : uppercases) {
            num += uppercase / 2;
            if (!hasOdd) {
                hasOdd = (uppercase % 2 != 0);
            }
        }

        return num * 2 + (hasOdd ? 1 : 0);
    }

    public int longestPalindrome1(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans = ans + (v / 2) * 2;
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}
