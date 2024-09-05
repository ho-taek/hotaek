package 알고리즘;

import java.io.IOException;
import java.util.Arrays;

public class _비트마스킹 {

    public static void main(String[] args) throws IOException {
        int[][] dp = new int[4][(1 << 4) - 1];

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }
}
