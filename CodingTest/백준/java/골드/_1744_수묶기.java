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

        // 음수끼리 곱하기 (0 포함 가능)
        while (start < end && arr[start] < 0 && arr[start + 1] <= 0) {
            answer += arr[start] * arr[start + 1];
            start += 2; // 두 개를 곱했으므로 인덱스를 2 증가
        }

        // 양수끼리 곱하기 (1 제외)
        while (end > 0 && arr[end] > 1 && arr[end - 1] > 1) {
            answer += arr[end] * arr[end - 1];
            end -= 2; // 두 개를 곱했으므로 인덱스를 2 감소
        }

        // 음수나 양수 남은 값 더하기
        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        for (int i = end; i >= start; i--) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
