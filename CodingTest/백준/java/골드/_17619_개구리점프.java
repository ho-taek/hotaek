package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _17619_개구리점프 {

    public static int[] parent;

    public static class Frog implements Comparable<Frog> {
        int x1;
        int x2;
        int y;
        int num;

        public Frog(int x1, int x2, int y, int num) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Frog frog) {
            if (this.x1 == frog.x1) {
                return this.x2 - frog.x2;
            }
            return this.x1 - frog.x1;
        }

        @Override
        public String toString() {
            return "num " + this.num + " " + this.x1 + " " + this.x2 + " " + this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        List<Frog> li = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new Frog(x1, x2, y, i));
            parent[i] = i;
        }

        Collections.sort(li);

        int right = li.get(0).x2;
        int num = li.get(0).num;
        for (int i = 1; i < n; i++) {
            Frog frog = li.get(i);
            if (frog.x1 <= right) {
                union(num, frog.num);
                right = Math.max(right, frog.x2);
            } else {
                num = find(frog.num);
                right = frog.x2;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
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

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
