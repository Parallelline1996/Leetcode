/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:54
 */

package page4;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class N387_FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        // 遍历26个字母
        for (char c = 'a'; c <= 'z'; c++) {
            // 查询每个字母在字符串里的最头一个的位置
            int i = s.indexOf(c);
            // 如果该字母在字符串里存在，再判断该字母在字符串里的最末一个的位置
            if (i != -1 && s.lastIndexOf(c) == i) {
                // 判断26个字母哪个是唯一存在，且坐标最小
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
