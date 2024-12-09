package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2343_기타레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        // right 설정 및 그래프 설정
        long right = 0;
        long left = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (left < value)
                left = value;
            arr[i] = value;
            right += value;
        }

        // 이진 탐색
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int tmp = 1;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    tmp++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if (tmp > m)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(left);
    }
}
