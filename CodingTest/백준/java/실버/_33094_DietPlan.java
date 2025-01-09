package 백준.java.실버;

import java.util.*;
import java.io.*;

public class _33094_DietPlan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int tm = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            tm += arr[i];
            pq.offer(arr[i]);
            answer++;

            while (tm > m && k > 0 && !pq.isEmpty()) {
                int tmp = pq.poll();
                tm -= tmp;
                k--;
            }

            if (tm > m) {
                answer--;
                break;
            }
        }

        System.out.println(answer);
    }

}
