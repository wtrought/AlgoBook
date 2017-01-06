package string.AlgoBook;

import org.junit.Test;

import static string.AlgoBook.LongestDistinctSubstring.longestDistinctSubstring;

/**
 * Created by Winston on 10/18/16.
 */
public class LongestDistinctSubstringTest {

    @Test
    public void leetcode() {
        String a = "abcabcbb";
        String b = longestDistinctSubstring(a);
        assert(b.equals("abc") || b.equals("bca") || b.equals("cab"));
    }

    @Test
    public void leetcode2() {
        String a = "ab";
        String b = longestDistinctSubstring(a);
        assert(b.equals("ab"));
    }

    @Test
    public void leetcode3() {
        String a = "aab";
        String b = longestDistinctSubstring(a);
        assert(b.equals("ab"));
    }

    @Test
    public  void leetcode4() {
        String a = "";
        String b = longestDistinctSubstring(a);
    }
}
