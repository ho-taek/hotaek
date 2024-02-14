package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2578 {
  static int[][] array;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    array = new int[5][5];
    count = 0;
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int result = 0;

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        result++;
        int tmp = Integer.parseInt(st.nextToken());
        boolean flag = false;
        for (int a = 0; a < 5; a++) {
          for (int b = 0; b < 5; b++) {
            if (array[a][b] == tmp) {
              array[a][b] = 0;
              flag = true;
              break;
            }
          }
          if (flag)
            break;
        }
        count = 0;
        col();
        row();
        side();

        if (count >= 3) {
          System.out.println(result);
          System.exit(0);
        }

      }
    }
  }

  // 행
  public static void col() {
    for (int i = 0; i < 5; i++) {
      int tmp = 0;
      for (int j = 0; j < 5; j++) {
        if (array[i][j] == 0) {
          tmp++;
        }
      }
      if (tmp == 5) {
        count++;
      }
    }
  }

  // 열
  public static void row() {
    for (int i = 0; i < 5; i++) {
      int tmp = 0;
      for (int j = 0; j < 5; j++) {
        if (array[j][i] == 0) {
          tmp++;
        }
      }
      if (tmp == 5) {
        count++;
      }
    }
  }

  // 대각선
  public static void side() {
    int left = 0;
    int right = 0;
    for (int i = 0; i < 5; i++) {
      if (array[i][i] == 0) {
        right++;
      }
      if (array[i][4 - i] == 0) {
        left++;
      }
    }
    if (left == 5) {
      count++;
    }
    if (right == 5) {
      count++;
    }
  }
}
