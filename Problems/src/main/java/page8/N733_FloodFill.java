/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2023/4/5 21:36
 */

package page8;

/**
 * https://leetcode.com/problems/flood-fill/
 * <p>
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class N733_FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 新旧值相同，直接返回入参
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }

        floodFill(image, sr, sc, color, oldColor);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        // 图的边界条件判断
        if (sr >= image.length || sr < 0 || sc < 0 || sc >= image[0].length) {
            return;
        }

        // 判断该点是否需要被更新
        if (image[sr][sc] == newColor || image[sr][sc] != oldColor) {
            return;
        }

        // 更新该点，并对“上下左右”四点进行判断
        image[sr][sc] = newColor;
        floodFill(image, sr - 1, sc, newColor, oldColor);
        floodFill(image, sr + 1, sc, newColor, oldColor);
        floodFill(image, sr, sc - 1, newColor, oldColor);
        floodFill(image, sr, sc + 1, newColor, oldColor);
    }
}
