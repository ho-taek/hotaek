import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _수영장 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] array = new int[4];

      for (int i = 0; i < 4; i++) {
        array[i] = Integer.parseInt(st.nextToken());
      }

      int[] dp = new int[13];
      int ans = array[3];
      StringTokenizer sty = new StringTokenizer(br.readLine());
      for (int i = 1; i <= 12; i++) {
        dp[i] = Integer.parseInt(sty.nextToken());
      }

      dp[1] = (dp[1] * array[0] > array[1]) ? array[1] : dp[1] * array[0];
      dp[2] = ((dp[2] * array[0]) > array[1]) ? dp[1] + array[1] : (dp[1] + dp[2] * array[0]);

      for (int i = 3; i <= 12; i++) {
        int day = dp[i - 1] + (dp[i] * array[0]);
        int month = dp[i - 1] + array[1];
        int three = dp[i - 3] + array[2];
        int[] num = { day, month, three };
        Arrays.sort(num);
        dp[i] = num[0];
      }

      ans = (array[3] > dp[12]) ? dp[12] : array[3];

      System.out.println("#" + t + " " + ans);

    }

  }
}
