package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _12869_뮤탈리스크 {

    static int[][] attack = {
            { 9, 3, 1 },
            { 9, 1, 3 },
            { 3, 9, 1 },
            { 3, 1, 9 },
            { 1, 3, 9 },
            { 1, 9, 3 }
    };

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scv = new int[4]; // hp1, hp2, hp3, count

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // scv 초기화
            scv[i] = Integer.parseInt(st.nextToken());
        }

        scv[3] = 1;

        bfs(scv);

        System.out.println(answer);
    }

    public static void bfs(int[] scv) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> s = new HashSet<>();
        queue.offer(scv);

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            int[] tmp = new int[] { q[0], q[1], q[2] };
            s.add(getString(tmp));
            for (int i = 0; i < 6; i++) {
                int one = q[0] - attack[i][0];
                int two = q[1] - attack[i][1];
                int three = q[2] - attack[i][2];
                if (one <= 0 && two <= 0 && three <= 0) {
                    answer = q[3];
                    return;
                } else {
                    int[] scvHp = new int[] { one, two, three, q[3] + 1 };
                    String visit = getString(new int[] { one, two, three });
                    if (!s.contains(visit)) {
                        queue.offer(scvHp);
                        s.add(visit);
                    }
                }

            }
        }
    }

    public static String getString(int[] arr) {
        Arrays.sort(arr);

        String s1 = String.valueOf(arr[0]);
        String s2 = String.valueOf(arr[1]);
        String s3 = String.valueOf(arr[2]);

        return s1 + s2 + s3;
    }
}
