package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20366_같이_눈사람_만들자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] graph = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        Arrays.sort(graph);

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = (i + 1); j < n; j++) {
                dp[i][j] = graph[i] + graph[j];
            }
        }

        // for (int i = 0; i < n; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }

        for (int i = 0; i < n; i++) {
            for (int j = (i + 1); j < n; j++) {
                int anaLeft = i;
                int anaRight = i;
                while(anaLeft < (n-1) && anaLeft == i || anaLeft == j){
                        anaLeft++;
                }
                while(anaRight < (n-1) && anaRight == i || anaRight == j || anaRight == anaLeft){
                        anaRight ++;
                }
                System.out.println(anaLeft + " abc " + anaRight);
                int tmp = calc(dp[i][j], anaLeft,anaRight, dp);
                if(result < tmp){
                    break;
                }else{
                    System.out.println(anaLeft + " " + anaRight);
                    result = tmp;
                }
            }
        }
        System.out.println(result);
    }

    public static int calc(int elsa, int a, int b, int[][] dp){
        return Math.abs(elsa - dp[a][b]);
    }
}
