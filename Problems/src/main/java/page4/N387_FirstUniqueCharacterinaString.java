/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:54
 */

package page4;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class N387_FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i != -1 && s.lastIndexOf(c) == i) {
                result = Math.min(result, i);
            }
        }
        return result == Integer.MAX_VALUE? -1: result;
    }

    /**
     * 31ms
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
