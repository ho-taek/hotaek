package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1244 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] array = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    int index = 0;
    while (st.hasMoreTokens()) {
      array[index] = Integer.parseInt(st.nextToken());
      index++;
    }

    int m = Integer.parseInt(br.readLine());

    for (int a = 0; a < m; a++) {
      StringTokenizer str = new StringTokenizer(br.readLine());
      int tag = Integer.parseInt(str.nextToken());
      int num = Integer.parseInt(str.nextToken());

      // 남
      if (tag == 1) {
        array = calMan(num, array, n);
      } else {
        // 여
        array = calWoman(num - 1, array, n);
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(array[i] + " ");
      if ((i + 1) % 20 == 0) {
        System.out.println(array[i]);
      }
    }
  }

  public static int[] calMan(int num, int[] array, int n) {
    for (int i = num - 1; i < n; i += num) {
      if (array[i] == 0) {
        array[i] = 1;
      } else {
        array[i] = 0;
      }
    }
    return array;
  }

  public static int[] calWoman(int num, int[] array, int n) {
    int index = 1;
    array[num] = (array[num] == 1) ? 0 : 1;
    while ((num - index >= 0) && (num + index < n)) {
      if (array[num - index] == array[num + index]) {
        array[num - index] = (array[num - index] == 1) ? 0 : 1;
        array[num + index] = (array[num + index] == 1) ? 0 : 1;
      } else {
        break;
      }
      index++;
    }
    return array;
  }
}
