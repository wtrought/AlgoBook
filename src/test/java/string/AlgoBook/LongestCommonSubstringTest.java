package string.AlgoBook;

import org.junit.Test;

import java.io.*;

/**
 * Created by Winston on 10/18/16.
 */
public class LongestCommonSubstringTest {
    String s1;
    String s2;
    String expectedString;
    String substring;

    @Test
    public void identicalStringTest() {
        s1 = "abcabcabcadcaserjkewnfalsdncpwenropqwnasdf";
        s2 = "abcabcabcadcaserjkewnfalsdncpwenropqwnasdf";
        substring = LongestCommonSubstring.longestCommonSubstring(s1, s2);
        assert s1.equals(substring);
        assert s2.equals(substring);
    }

    @Test
    public void differentSizeTest() {
        s1 = "coffeeimade";
        s2 = "made";
        expectedString = "made";
        substring = LongestCommonSubstring.longestCommonSubstring(s1, s2);
        assert substring.equals(expectedString);
    }

    @Test
    public void stressTest() {

    }
}
