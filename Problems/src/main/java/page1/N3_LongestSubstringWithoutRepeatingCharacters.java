/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/22 10:33
 */

package page1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class N3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcdefg"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("ABB"));
        System.out.println(new N3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("AAB"));
    }

    /**
     * Use map to record the index of the element in each traversal
     * When the key is the same, calculate the current maximum length,
     * and remove the elements from the starting point of this traverse to the repeated value in the map.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                for (int j = start; j < map.get(a); j++) {
                    map.remove(s.charAt(j));
                }
                maxLength = Math.max(i - start, maxLength);
                start = map.get(a) + 1;
            }
            map.put(a, i);
        }

        maxLength = Math.max(s.length() - start, maxLength);
        return maxLength;
    }

    /**
     * faster
     */
    public int lengthOfLongestSubstring1(String s) {
        int start = 0;
        int result = 0;
        boolean[] map = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map[c]) {
                map[c] = true;
            } else {
                while (map[c]) {
                    map[s.charAt(start)] = false;
                    start++;
                }
                map[c] = true;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
