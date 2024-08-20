package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1806_부분합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int answer = 100001;
        int tmp = 0;
        while (true) {
            if (tmp >= m) {
                if (answer > (end - start)) {
                    answer = end - start;
                }

                tmp -= array[start];
                start++;
            } else if (end == n) {
                break;
            } else {
                tmp += array[end];
                end++;
            }
        }
        if (answer == 100001) {
            answer = 0;
        }

        System.out.println(answer);

    }
}
