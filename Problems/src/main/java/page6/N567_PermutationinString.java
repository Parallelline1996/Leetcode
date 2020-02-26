/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/25 23:25
 */

package page6;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class N567_PermutationinString {

    public static void main(String[] args) {
        System.out.println(new N567_PermutationinString().checkInclusion("adc", "dcda"));
        System.out.println(new N567_PermutationinString().checkInclusion1("adc", "dcda"));
    }

    /**
     * sliding window
     */
    public boolean checkInclusion1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        int[] array1 = new int[26];
        for (int i = 0; i < n1; i++){
            array1[s1.charAt(i) - 'a']++;
        }

        int[] array2 = new int[26];
        for (int i = 0; i <= n2 - n1; i++) {
            if (i == 0) {
                for (int j = 0; j < n1; j++) {
                    array2[s2.charAt(j) - 'a']++;
                }
            } else {
                array2[s2.charAt(i + n1 - 1) - 'a']++;
                array2[s2.charAt(i - 1) - 'a']--;
            }

            if (Arrays.equals(array1, array2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(n²)
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] num = new int[26];
        for (char c : s1.toCharArray()
        ) {
            num[c - 'a']++;
        }

        int length = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (num[s2.charAt(i) - 'a'] > 0) {
                num[s2.charAt(i) - 'a']--;
                length++;
                if (length >= s1.length()) {
                    return true;
                }
            } else {
                for (int j = 1; j <= length; j++) {
                    num[s2.charAt(i - j) - 'a']++;
                }
                i = i - length;
                length = 0;
            }
        }

        return false;
    }
}
