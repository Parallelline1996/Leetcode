/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 15:42
 */

package page1;

import org.junit.Assert;
import org.junit.Test;

public class N58_LengthofLastWordTest {

    @Test
    public void test() {
        Assert.assertEquals(0, new N58_LengthofLastWord().lengthOfLastWord(" "));
        Assert.assertEquals(3, new N58_LengthofLastWord().lengthOfLastWord("aaa "));
        Assert.assertEquals(3, new N58_LengthofLastWord().lengthOfLastWord(" aaa"));
        Assert.assertEquals(3, new N58_LengthofLastWord().lengthOfLastWord("f aaa"));
    }
}
