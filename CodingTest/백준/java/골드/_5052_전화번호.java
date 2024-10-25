package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5052_전화번호 {

    static class Node {
        boolean value;
        Map<Character, Integer> children;

        Node() {
            this.value = false;
            this.children = new HashMap<>();
        }
    }

    static List<Node> trie;

    static int init() {
        Node node = new Node();
        trie.add(node);
        return trie.size() - 1;
    }

    static boolean add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).value = true;
            return true;
        }

        if (trie.get(node).value) {
            return false;
        }

        char c = s.charAt(index);
        trie.get(node).children.putIfAbsent(c, init());
        return add(trie.get(node).children.get(c), s, index + 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            trie = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String[] array = new String[n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                array[i] = s;
            }

            Arrays.sort(array);
            init();
            boolean flag = true;
            for (String s : array) {
                if (!add(0, s, 0)) {
                    flag = false;
                    System.out.println("NO");
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            }

        }
    }
}
