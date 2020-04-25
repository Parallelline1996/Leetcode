/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/22 23:04
 */

package page11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 *
 * Given an array A of strings made only from lowercase letters,
 * return a list of all characters that show up in all strings within the list (including duplicates).
 * For example, if a character occurs 3 times in all strings but not 4 times,
 * you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 * Note:
 *
 *     1 <= A.length <= 100
 *     1 <= A[i].length <= 100
 *     A[i][j] is a lowercase letter
 */
public class N1002_FindCommonCharacters {

    /**
     * 6ms
     */
    public List<String> commonChars(String[] A) {
        List<String> lists = new ArrayList<>();
        if (A == null || A.length == 0) {
            return lists;
        }

        int[] total = new int[26];
        Arrays.fill(total, Integer.MAX_VALUE);
        for (String s : A) {
            int[] local = new int[26];
            for (char c : s.toCharArray()) {
                local[c - 'a']++;
            }

            for (int j = 0; j < total.length; j++) {
                total[j] = Math.min(total[j], local[j]);
            }
        }

        for (int i = 0; i < total.length; i++) {
            for (int j = 0; j < total[i]; j++) {
                lists.add((char)(i + 'a') + "");
            }
        }
        return lists;
    }
}
