/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/13 23:52
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class N56_MergeIntervals {

    public static void main(String[] args) {
        int[][] request = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] response = new N56_MergeIntervals().merge(request);
        for (int[] res : response) {
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int[][] request1 = new int[][]{
                {1,4},{4,5}
        };
        int[][] response1 = new N56_MergeIntervals().merge(request1);
        for (int[] res : response1) {
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // add the first interval
        List<int[]> lists = new ArrayList<>();
        lists.add(intervals[0]);

        // traverse all time intervals, and merge with the lists data
        for (int i = 1; i < intervals.length; i++) {
            int[] newInter = intervals[i];
            for (int j = 0; j < lists.size(); j++) {
                int[] oldInter = lists.get(j);
                if (overlap(oldInter, newInter)) {
                    newInter[0] = Math.min(oldInter[0], newInter[0]);
                    newInter[1] = Math.max(oldInter[1], newInter[1]);
                    lists.remove(j--);
                }
            }
            lists.add(newInter);
        }

        return lists.toArray(new int[lists.size()][]);
    }

    /**
     * check whether two interval is overlap
     */
    private boolean overlap(int[] oldInter, int[] newInter) {
        return (oldInter[1] >= newInter[0] && newInter[1] >= oldInter[0]);
    }
}
