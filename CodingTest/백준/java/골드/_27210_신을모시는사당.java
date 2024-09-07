package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _27210_신을모시는사당 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] left = new int[n];
        int[] right = new int[n];

        int first = Integer.parseInt(st.nextToken());
        if (first == 1) {
            left[0] = 1;
        } else {
            right[0] = 1;
        }
        int answer = 1;
        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 1) {
                left[i] = left[i - 1] + 1;
                right[i] = right[i - 1];
            } else {
                right[i] = right[i - 1] + 1;
                left[i] = left[i - 1];
            }
            answer = Math.max(answer, Math.abs(left[i] - right[i]));
        }

        System.out.println(answer);
    }
}
