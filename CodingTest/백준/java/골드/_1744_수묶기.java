package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _1744_수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) { // 배열 초기화
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int answer = 0;

        if (n == 1) { // n이 1일 경우
            System.out.println(arr[0]);
            return;
        }

        while (start < end && arr[start] < 0 && arr[start + 1] <= 0) { // 음수곱
            answer += arr[start] * arr[start + 1];
            start += 2;
        }

        while (end > 0 && arr[end] > 1 && arr[end - 1] > 1) { // 양수 곱
            answer += arr[end] * arr[end - 1];
            end -= 2;
        }

        for (int i = end; i >= start; i--) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
