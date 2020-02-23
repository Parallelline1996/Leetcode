/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/23 10:26
 */

package page14;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 * Example 1:
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are
 * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 *
 * Example 2:
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 *
 * Example 3:
 * Input: s = "abc"
 * Output: 1
 *
 * Constraints:
 *     3 <= s.length <= 5 x 10^4
 *     s only consists of a, b or c characters.
 */
public class N1358_NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        System.out.println(new N1358_NumberOfSubstringsContainingAllThreeCharacters().numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        int start = 0, end = 0, number = 0;
        int[] nums = new int[3];

        while (end < s.length()) {
            nums[s.charAt(end++) - 'a']++;
            while (nums[0] > 0 && nums[1] > 0 && nums[2] > 0) {
                nums[s.charAt(start++) - 'a']--;
            }
            number += start;
        }

        return number;
    }


}
