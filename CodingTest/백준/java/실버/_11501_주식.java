package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11501_주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int s = Integer.parseInt(br.readLine());

            int[] arr = new int[s];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < s; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 0;
            long max = 0;
            for (int j = s - 1; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    answer += max - arr[j];
                }
            }
            System.out.println(answer);
        }
    }
}
