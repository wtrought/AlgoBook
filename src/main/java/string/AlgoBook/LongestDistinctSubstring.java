package string.AlgoBook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Winston on 10/18/16.
 */
public class LongestDistinctSubstring {
    public static String longestDistinctSubstring(String s) {
        int end = s.length();
        int max = 0;
        int i_max = -1;
        int j_max = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < end; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            if (max < j - i + 1) {
                max = j - i + 1;
                i_max = i;
                j_max = j + 1;
            }

            map.put(s.charAt(j), j+1);
        }
        return s.substring(i_max, j_max);
    }
}