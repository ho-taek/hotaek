package 백준.java.골드;

import java.io.*;
import java.util.*;

public class _5052_전화번호목록_3 {

    static class Node {
        boolean valid;
        HashMap<Character, Integer> children;

        public Node() {
            this.valid = false;
            children = new HashMap<>();
        }
    }

    static List<Node> trie;

    public static int init() {
        Node node = new Node();
        trie.add(node);

        return trie.size() - 1;
    }

    public static boolean add(int node, String s, int index) {

        if (s.length() == index) {
            trie.get(node).valid = true;
            return true;
        }

        if (trie.get(node).valid) {
            return false;
        }

        char c = s.charAt(index);
        trie.get(node).children.putIfAbsent(c, init());
        return add(trie.get(node).children.get(c), s, index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            trie = new ArrayList<>();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = br.readLine();
            }

            Arrays.sort(s);
            init();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!add(0, s[i], 0)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
