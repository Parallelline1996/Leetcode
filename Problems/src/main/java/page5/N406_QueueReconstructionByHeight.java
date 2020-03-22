/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/21 21:53
 */

package page5;

import java.util.*;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * <p>
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class N406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people
        ) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }
}
