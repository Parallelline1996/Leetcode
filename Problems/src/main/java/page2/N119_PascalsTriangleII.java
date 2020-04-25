/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/25 0025 18:33
 */

package page2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class N119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }

        int[] array = buildTriangle(rowIndex + 1);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < rowIndex + 1; j++) {
            list.add(array[j]);
        }
        return list;
    }

    private int[] buildTriangle(int rowIndex) {
        int[] array = new int[rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    array[j] = 1;
                } else {
                    array[j] = array[j - 1] + array[j];
                }
            }
        }
        return array;
    }
}
