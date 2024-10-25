package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14425_문자열집합 {

    static List<Node> trie;

    static class Node {
        boolean value;
        Map<Character, Integer> character;

        Node() {
            this.value = false;
            this.character = new HashMap<>();
        }
    }

    static int init() {
        Node node = new Node();
        trie.add(node);

        return trie.size() - 1;
    }

    static void add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).value = true;
            return;
        }

        char c = s.charAt(index);
        trie.get(node).character.putIfAbsent(c, init());
        add(trie.get(node).character.get(c), s, index + 1);
    }

    static boolean check(int node, String s, int index) {
        if (s.length() == index) {
            System.out.println("#### " + s + "#####");
            return trie.get(node).value;
        }

        char c = s.charAt(index);

        if (!trie.get(node).character.containsKey(c)) {
            return false;
        }

        return check(trie.get(node).character.get(c), s, index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trie = new ArrayList<>();
        init();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            add(0, s, 0);
        }
        int answer = 0;
        for (int j = 0; j < m; j++) {
            String s = br.readLine();
            if (check(0, s, 0)) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
