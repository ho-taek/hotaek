package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _4195_친구네트워크 {

    static int[] parent;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            int num = 1;
            parent = new int[2 * n + 1];
            answer = new int[2 * n + 1];

            for (int i = 1; i < 2 * n + 1; i++) {
                parent[i] = i;
                answer[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, num);
                    num++;
                }
                if (!map.containsKey(b)) {
                    map.put(b, num);
                    num++;
                }
                int aNum = map.get(a); // 해당하는 이름의 value값
                int bNum = map.get(b);

                union(aNum, bNum); // aNum -> true, bNum -> false

                int root = find(aNum);
                bw.write(answer[root] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
                answer[x] += answer[y];
            } else {
                parent[x] = y;
                answer[y] += answer[x];
            }
        }

    }

    public static int find(int x) {
        if (parent[x] != x) {
            return x;
        }
        return find(parent[x]);
    }
}
