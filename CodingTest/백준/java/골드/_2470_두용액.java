package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int value = array[left] + array[right];

            if (Math.abs(value) < min) {
                System.out.println(array[left] + " " + array[right]);
                answer[0] = array[left];
                answer[1] = array[right];
                min = Math.abs(value);
                if (value == 0)
                    break;
            }

            if (value < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
