package dynamic_programming.AlgoBook;

/**
 *  @Author Winston Troughton
 */

import java.util.Arrays;

/**
 *  A[0] always contains length 1.
 *  A[n+1] elements are either A[n] + 1 or A[n]
 *
 */
public class LongestIncreasingSequence {

    private static void initializeMemo(int[] memo) {
        for(int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }
    }

    public static int longestIncreasingSubsequence(int[] numbers) {
        int[] memo = new int[numbers.length];
        initializeMemo(memo);
        for (int i = 1; i < memo.length; i++)
            for(int j = 0; j < i; ++j)
                if(numbers[j] < numbers[i])
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
        int max = Arrays.stream(memo).max().getAsInt();
        return max;
    }
}
