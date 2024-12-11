package 백준.java.실버;

import java.util.*;
import java.io.*;

public class _1072_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long z = (y * 100 / x);

        int left = 1;
        int right = 1000000000;

        long answer = Long.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            long tmp = ((y + mid) * 100) / (x + mid);

            if (z >= tmp) {
                left = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        if (answer == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
