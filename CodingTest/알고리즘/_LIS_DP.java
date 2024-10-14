package 알고리즘;

import java.io.IOException;
import java.util.*;

public class _LIS_DP {

    public static void main(String[] args) throws IOException {
        int[] arr = { 5, 6, 3, 4, 2, 7, 8, 5 };
        int[] dp = new int[8];

        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }
                dp[i] = tmp + 1;
            }
        }

        System.out.println(Arrays.toString(dp));
    }

}
