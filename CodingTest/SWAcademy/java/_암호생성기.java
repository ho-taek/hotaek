import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _암호생성기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int t = 1; t <= 10; t++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      Queue<Integer> queue = new LinkedList<>();

      // 값 할당
      System.out.println(st);
      while (st.hasMoreTokens()) {
        queue.add(Integer.parseInt(st.nextToken()));
      }

      boolean flag = true;
      while (true) {
        for (int i = 1; i <= 5; i++) {
          int top = queue.poll() - i;

          int value = top < 0 ? 0 : top;
          queue.offer(value);

          if (value == 0) {
            flag = false;
            break;
          }
        }
        if (!flag) {
          break;
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int i : queue) {
        sb.append(i).append(" ");
      }
      System.out.println("#" + t + " " + sb);
    }
  }
}
