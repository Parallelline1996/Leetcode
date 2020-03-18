/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/16 22:32
 */

package page1;

import org.junit.Assert;
import org.junit.Test;

public class N79_WordSearchTest {

    @Test
    public void test1() {
        char[][] a = new char[][]{{'a', 'a'}};
        Assert.assertFalse(new N79_WordSearch().exist(a, "aaa"));
    }

    @Test
    public void test2() {
        char[][] a = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Assert.assertTrue(new N79_WordSearch().exist(a, "ABCCED"));
        Assert.assertTrue(new N79_WordSearch().exist(a, "SEE"));
        Assert.assertFalse(new N79_WordSearch().exist(a, "ABCB"));
    }
}
