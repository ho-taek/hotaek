package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _2252_줄세우기 {

    static int[] input;
    static List<List<Integer>> li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = new int[n + 1];
        li = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li.get(a).add(b);
            input[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (input[i] == 0) {
                bw.write(i + " ");
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer q = queue.poll();

            for (int i : li.get(q)) {
                input[i]--;

                if (input[i] == 0) {
                    bw.write(i + " ");
                    queue.offer(i);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
