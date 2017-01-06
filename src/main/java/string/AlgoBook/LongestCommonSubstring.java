package string.AlgoBook;

/**
 * Created by Winston on 10/18/16.
 */
public class LongestCommonSubstring {
    public static String longestCommonSubstring(String s1, String s2) {
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int match = 0;
                int a = i;
                int b = j;
                boolean matched = true;
                while (matched) {
                    if (a >= s1.length() || b >= s2.length())
                        matched = false;
                    else if (s1.charAt(a++) == s2.charAt(b++)) {
                        match++;
                        if (match > maxLen) {
                            maxLen = match;
                            begin = i;
                        }
                    }
                    else
                        matched = false;
                }
            }
        }
        return s1.substring(begin, begin+maxLen);
    }
}
