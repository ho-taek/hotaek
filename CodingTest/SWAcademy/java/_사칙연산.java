import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.*;

public class _사칙연산 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> set = new HashSet<>();
    set.add("*");
    set.add("-");
    set.add("/");
    set.add("+");
    for (int t = 1; t <= 10; t++) {
      int n = Integer.parseInt(br.readLine());
      int[] tree = new int[n + 1];
      HashMap<Integer, String[]> map = new HashMap<>();
      int max = 0;

      for (int i = 1; i <= n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();
        if (st.countTokens() == 2) {
          String c = st.nextToken();
          String d = st.nextToken();
          String[] array = { b, c, d };
          map.put(a, array);
          if (max < a) {
            max = a;
          }
        } else {
          tree[a] = Integer.parseInt(b);
        }

      }
      for (int j = max; j >= 1; j--) {
        if (map.keySet().contains(j)) {
          System.out.println("확인");
          String[] value = map.get(j);
          System.out.println("제이" + " " + j);

          int first = tree[Integer.parseInt(value[1])];
          int second = tree[Integer.parseInt(value[2])];
          switch (value[0]) {
            case "*":
              tree[j] = first * second;
              break;
            case "/":
              tree[j] = first / second;
              break;
            case "+":
              tree[j] = first + second;
              break;
            case "-":
              tree[j] = first - second;
              break;
            default:
              break;
          }
        } else {
          continue;
        }
      }
      System.out.println(Arrays.toString(tree));
      System.out.println(tree[1]);
    }
  }
}
