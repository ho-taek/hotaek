package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _3745_오름세 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input.trim());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> li = new ArrayList<>();

            for (int i : arr) {
                if (li.isEmpty()) {
                    li.add(i);
                    continue;
                }

                if (li.get(li.size() - 1) < i) {
                    li.add(i);
                    continue;
                }

                int left = 0;
                int right = li.size() - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (li.get(mid) < i) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                li.set(left, i);
            }

            bw.write(li.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
