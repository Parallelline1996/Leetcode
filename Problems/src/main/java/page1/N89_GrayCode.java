/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/22 12:53
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * Example 2:
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class N89_GrayCode {

    public static void main(String[] args) {
        new N89_GrayCode().grayCode1(3);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }

        String[] grayCode = getGrayCode(n);
        for (String s : grayCode
        ) {
            list.add(Integer.parseInt(s, 2));
        }
        return list;
    }

    private String[] getGrayCode(int n) {
        if (n == 1) {
            return new String[]{"0", "1"};
        }

        String[] temp = getGrayCode(n - 1);
        String[] result = new String[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            result[i] = "0" + temp[i];
            result[result.length - i - 1] = "1" + temp[i];
        }
        return result;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
