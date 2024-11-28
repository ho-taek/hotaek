package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _2467_용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        long tmp = Long.MAX_VALUE;
        long[] answer = new long[2];

        while (left < right) {
            long sum = arr[left] + arr[right];
            System.out.println(tmp);
            if (Math.abs(sum) < tmp) {
                tmp = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}
