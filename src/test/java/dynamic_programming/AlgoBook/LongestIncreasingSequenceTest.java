package dynamic_programming.AlgoBook;

import org.junit.Test;

import static dynamic_programming.AlgoBook.LongestIncreasingSequence.longestIncreasingSubsequence;

/**
 * Created by Winston on 10/19/16.
 */
public class LongestIncreasingSequenceTest {

    int[] sequence;

    @Test
    public void sampleProblem() {
        sequence = new int[] {3, 4, -1, 0, 6, 2, 3};
        int a = longestIncreasingSubsequence(sequence);
        assert a == 4;
    }

    @Test
    public void random() {

    }
}
