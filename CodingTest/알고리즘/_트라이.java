package 알고리즘;

import java.util.*;

class Node {
    boolean valid;
    Map<Character, Integer> children;

    Node() {
        this.valid = false;
        this.children = new HashMap<>();
    }
}

public class _트라이 {
    static List<Node> trie;

    static int init() {
        Node x = new Node();
        trie.add(x);
        // index값을 return 하는 것.
        return trie.size() - 1;
    }

    static boolean add(int node, String s, int index) {
        // 모든 문자열을 다 넣었을 때 이상이 없는 경우
        if (index == s.length()) {
            trie.get(node).valid = true;
            return true;
        }
        // 중간에 조회할 때 이미 있는 문자열일 경우 false 리턴
        if (trie.get(node).valid) {
            return false;
        }
        char c = s.charAt(index);
        trie.get(node).children.putIfAbsent(c, init());
        return add(trie.get(node).children.get(c), s, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            trie = new ArrayList<>();
            init();
            int n = sc.nextInt();
            String[] s = new String[n];
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }
            Arrays.sort(s);
            for (String str : s) {
                if (!add(0, str, 0)) {
                    ans = false;
                    break;
                }
            }

            System.out.println(ans ? "YES" : "NO");
        }
        sc.close();
    }
}
