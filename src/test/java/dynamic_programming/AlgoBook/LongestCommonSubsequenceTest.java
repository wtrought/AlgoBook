package dynamic_programming.AlgoBook;

import org.junit.Test;

import java.io.*;

import static dynamic_programming.AlgoBook.LongestCommonSubsequence.longestCommonSubsequence;

/**
 * @author Winston on 10/19/16.
 */
public class LongestCommonSubsequenceTest {

    String s1 = null;
    String s2 = null;
    String substring = null;

    @Test
    public void print2DArray() {
        s1 = "abcdef";
        s2 = "abdcfz";
        longestCommonSubsequence(s1, s2);
    }

    @Test
    public void randomTest() {
        try {
            InputStream inputStream0 = this.getClass().
                    getResourceAsStream("/longestCommonSubsequenceTest.txt");
            InputStream inputStream1 = this.getClass().
                    getResourceAsStream("/longestCommonSubsequenceOutput.txt");
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0));
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream1));
            while(bufferedReader0.ready()) {
                s1 = bufferedReader0.readLine();
                s2 = bufferedReader0.readLine();
                substring = LongestCommonSubsequence.longestCommonSubsequence(s1, s2);
                int expectedLength = Integer.parseInt(bufferedReader1.readLine());
                assert substring.length() == expectedLength;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
