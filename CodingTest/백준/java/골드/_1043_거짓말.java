package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1043_거짓말 {
    static int[] parent;
    static List<Integer> tList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int tCount = Integer.parseInt(st.nextToken());
        if (tCount == 0) {
            System.out.println(m);
            return;
        } else {
            tList = new ArrayList<>();

            for (int i = 0; i < tCount; i++) { // 진실을 아는 사람들 모음
                int value = Integer.parseInt(st.nextToken());
                tList.add(value);
            }
        }

        List<List<Integer>> pList = new ArrayList<>(); // 파티 참여자들

        for (int i = 0; i < m; i++) {
            pList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pCount = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            pList.get(i).add(x);
            for (int j = 1; j < pCount; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                pList.get(i).add(y);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean check = true;
            for (int j : pList.get(i)) {
                if (tList.contains(find(parent[j]))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (tList.contains(y)) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parent[y] = x;
    }
}
