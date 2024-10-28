package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _14725_개미굴 {

    public static class Node {
        HashMap<String, Node> children;

        public Node() {
            this.children = new HashMap<>();
        }
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node tmp = root;
            for (int j = 0; j < k; j++) {
                String s = st.nextToken();
                tmp.children.putIfAbsent(s, new Node());
                tmp = tmp.children.get(s);
            }
        }
        print(root, "");
        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void print(Node tmp, String s) {

        List<String> li = new ArrayList<>(tmp.children.keySet());
        Collections.sort(li);
        for (String str : li) {
            sb.append(s).append(str).append("\n");
            print(tmp.children.get(str), s + "--");
        }
    }
}
