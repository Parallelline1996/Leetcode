/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/2/23 22:50
 */

package page6;

/**
 * https://leetcode.com/problems/number-of-provinces/submissions/
 * <p>
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 * and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * <p>
 * Example 2:
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class N547_NumberOfProvinces {

    // 整体思路：
    // 对每一个未进入过的城市（isConnected[i][i] == 1）进行遍历
    // 经过一个城市，就标记为已进入（isConnected[i][i] == 0），并遍历该城市连接的所有城市
    // 判断有几次独立的从“未进入过的城市”开始遍历的

    // 1ms 92.45%
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 0) {
                continue;
            }

            num++;
            handle(isConnected, i);
        }
        return num;
    }

    private void handle(int[][] isConnected, int i) {
        if (i < 0 || i >= isConnected.length || isConnected[i][i] == 0) {
            return;
        }

        isConnected[i][i] = 0;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                handle(isConnected, j);
            }
        }
    }

    public static void main(String[] args) {
        // 1
        System.out.println(new N547_NumberOfProvinces().findCircleNum(
                new int[][]{
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}}
        ));
    }
}
