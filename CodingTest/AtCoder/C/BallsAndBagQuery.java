package AtCoder.C;

import java.util.*;
import java.io.*;

public class BallsAndBagQuery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1_000_001];
        StringTokenizer st;

        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                arr[b]++;
                if (arr[b] == 1) {
                    count++;
                }

            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                arr[b]--;
                if (arr[b] == 0) {
                    count--;
                }
            } else {
                System.out.println(count);
            }

        }

    }
}
