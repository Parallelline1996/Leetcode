/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/27 0:00
 */

package page2;

/**
 * https://leetcode.com/problems/dungeon-game/submissions/
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7
 * if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K) 	-3 	3
 * -5 	-10 	1
 * 10 	30 	-5 (P)
 *
 *
 *
 * Note:
 *
 *     The knight's health has no upper bound.
 *     Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class N174_DungeonGame {

    /**
     * 思路：
     * 如果从初始位置正向递推难度较大，因此，这里采用相反的思路，从终点向起点逆推
     * 这里需要引入特殊情况，就是需要保证每个点都能保证大于1
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
                    continue;
                }

                int minNeed = Math.min(j == dungeon[0].length - 1 ? Integer.MAX_VALUE : dp[i][j + 1],
                        i == dungeon.length - 1 ? Integer.MAX_VALUE : dp[i + 1][j]);
                dp[i][j] = Math.max(minNeed - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new N174_DungeonGame().calculateMinimumHP(
                new int[][]{
                        {-2,-3,3}, {-5,-10,1}, {10,30,-5}
                }
        ));
    }
}
