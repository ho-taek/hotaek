package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _5052_전화번호목록_2 {

    public static class Node {
        boolean flag;
        HashMap<Character, Integer> children;

        Node() {
            this.flag = false;
            this.children = new HashMap<>();
        }
    }

    static List<Node> trie;

    public static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size() - 1;
    }

    public static boolean add(int node, String s, int index) {

        if (index == s.length()) {
            trie.get(node).flag = true;
            return true;
        }

        if (trie.get(node).flag) {
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
            trie = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());

            String[] s = new String[n];

            for (int i = 0; i < n; i++) {
                s[i] = br.readLine();
            }
            init();
            Arrays.sort(s);
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
