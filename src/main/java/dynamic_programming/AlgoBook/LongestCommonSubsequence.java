package dynamic_programming.AlgoBook;

import java.awt.*;

/**
 *  @Author Winston Troughton 10/19/16.
 */
public class LongestCommonSubsequence {

    // Precondition s1.length() >= 1 && s2.length() >= 1
    public static String longestCommonSubsequence(String s1, String s2) {
        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for (int row = 1, column = 1; row < memo.length || column < memo[0].length; ++row, ++column) {
            for (int i = column, j = row; i < memo.length; i++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1]+1;
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            for (int i = column, j = row; j < memo[0].length; j++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1]+1;
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
        }
        tempHelperMethod(memo);
        StringBuilder answer = new StringBuilder();
        int tempI = 0; int tempJ = 0;   // Initialized to max
        while(memo[tempI][tempJ] != 0) {
            if(memo[tempI][tempJ] == Math.max(memo[tempI-1][tempJ], memo[tempI][tempJ-1])) {
                if(memo[tempI-1][tempJ] > memo[tempI][tempJ-1])
                    tempI -= 1;
                else
                    tempJ -= 1;
            }
            else {
                answer.insert(s1.charAt(tempI-1), answer);
                tempI -= 1; tempJ -= 1;
            }
        }
        return answer.toString();
    }

    public static void tempHelperMethod(int[][] arr) {
        for(int column = 0; column < arr.length; column++) {
            for (int row = 0; row < arr[column].length; column++)
                System.out.print(arr[row][column] + " ");
            System.out.print("\n");
        }
    }
}
