package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2669 {

  static int[][] array = new int[100][100];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int a = x1; a < x2; a++) {
        for (int b = y1; b < y2; b++) {
          array[a][b] = 1;
        }
      }
    }
    int result = 0;
    for (int a = 0; a < 100; a++) {
      for (int b = 0; b < 100; b++) {
        if (array[a][b] == 1) {
          result++;
        }
      }
    }
    System.out.println(result);
  }
}
