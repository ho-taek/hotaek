import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _수영장 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= 10; t++) {
      int[] arr = new int[4];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      StringTokenizer sty = new StringTokenizer(br.readLine());
      int[] year = new int[12];
      for (int i = 0; i < 12; i++) {
        year[i] = Integer.parseInt(sty.nextToken()) * arr[0];
      }

      int min = arr[3];

      // 일 -> 월
      for (int i = 0; i < 12; i++) {
        if (year[i] > arr[1]) {
          year[i] = arr[1];
        }
      }
      int value = Arrays.stream(year).sum();
      if (min > value) {
        min = value;
      }

      // 월 -> 일
      for (int i = 0; i < 10; i++) {
        int[] copy = year.clone();

        for (int j = i; j < 10; j += 2) {
          int tmp = copy[j] + copy[j + 1] + copy[j + 2];
          if (tmp > arr[2]) {
            copy[j] = arr[2];
            copy[j + 1] = 0;
            copy[j + 2] = 0;
          }

        }

        int valueTmp = Arrays.stream(copy).sum();
        if (min > valueTmp) {
          min = valueTmp;
        }
      }
      System.out.println("#" + t + " " + min);
    }
  }
}
