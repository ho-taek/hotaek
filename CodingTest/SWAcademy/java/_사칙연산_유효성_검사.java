import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _사칙연산_유효성_검사 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<String> set = new HashSet<>();
    set.add("*");
    set.add("-");
    set.add("/");
    set.add("+");
    for (int t = 1; t <= 10; t++) {
      int result = 1;
      int n = Integer.parseInt(br.readLine());
      String[] tree = new String[n + 1];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();
        if (st.countTokens() == 2) {
          if (!set.contains(b)) {
            result = 0;
          }
        } else {
          if (set.contains(b)) {
            result = 0;
          }
        }
      }
      System.out.println("#" + t + " " + result);

    }

  }
}
