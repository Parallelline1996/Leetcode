/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/6 16:21
 */

package page4;

/**
 * https://leetcode.com/problems/ransom-note/description/
 *
 *  Given an arbitrary ransom note string and another string containing letters from all the magazines,
 *  write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class N383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] source = new int[26];
        for (char c : magazine.toCharArray()) {
            source[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            source[c - 'a']--;
            if (source[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 6ms
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] target = new int[26];
        int[] source = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            target[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            source[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (target[i] > source[i]) {
                return false;
            }
        }
        return true;
    }
}
