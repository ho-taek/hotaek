import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            Deque<Integer> stack = new ArrayDeque<>();

            int n = Integer.parseInt(st.nextToken());
            String[] array = st.nextToken().split("");
            System.out.println(Arrays.toString(array));
            for (String s : array) {
                int parse = Integer.parseInt(s);
                if (stack.isEmpty()) {
                    stack.add(parse);
                } else {
                    System.out.println(stack.peekLast());
                    if (stack.peekLast() == parse) {
                        stack.pollLast();
                    } else {
                        stack.add(parse);
                    }
                }

            }
            StringBuilder sb = new StringBuilder();
            for (Integer s : stack) {
                sb.append(s);
            }
            System.out.println("#" + t + " " + sb);
        }
    }

}
