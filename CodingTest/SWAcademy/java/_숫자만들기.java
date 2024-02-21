import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class _숫자만들기 {
  static int arr[];
  static int max;
  static int min;
  static HashMap<Integer, String> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      int n = Integer.parseInt(br.readLine());

      map = new HashMap<>();
      map.put(0, "+");
      map.put(1, "-");
      map.put(2, "*");
      map.put(3, "/");

      StringTokenizer stc = new StringTokenizer(br.readLine());
      int[] liCal = new int[4];
      for (int i = 0; i < 4; i++) {
        liCal[i] = Integer.parseInt(stc.nextToken());
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      max = Integer.MIN_VALUE;
      min = Integer.MAX_VALUE;

      String[] output = new String[n - 1];
      boolean[] visited = new boolean[n - 1];

      perm(liCal, output, 0, n);

      System.out.println("#" + t + " " + (max - min));
    }
  }

  public static void perm(int[] liCal, String[] output, int depth, int n) {
    if (depth == (n - 1)) {
      calculate(output);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (liCal[i] != 0) {
        liCal[i] -= 1;
        output[depth] = map.get(i);
        perm(liCal, output, depth + 1, n);
        liCal[i] += 1;
      }
    }
  }

  public static void calculate(String[] output) {
    int tmp = arr[0];
    for (int i = 0; i < output.length; i++) {
      switch (output[i]) {
        case "+":
          tmp += arr[i + 1];
          break;
        case "-":
          tmp -= arr[i + 1];
          break;
        case "*":
          tmp *= arr[i + 1];
          break;
        case "/":
          tmp /= arr[i + 1];
          break;
        default:
          break;
      }
    }
    if (max < tmp) {
      max = tmp;
    }
    if (min > tmp) {
      min = tmp;
    }
  }

}
