/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/12 22:04
 */

package page8;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * Note:
 *     S and J will consist of letters and have length at most 50.
 *     The characters in J are distinct.
 */
public class N771_JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (Character c : J.toCharArray()
             ) {
            set.add(c);
        }

        int num = 0;
        for (Character c : S.toCharArray()
             ) {
            if (set.contains(c)) {
                num++;
            }
        }
        return num;
    }
}
