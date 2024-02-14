package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    StringTokenizer sta = new StringTokenizer(br.readLine());

    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(sta.nextToken());
    }
    int max = Integer.MIN_VALUE;
    if (n == 2) {
      if (k == 1) {
        max = (array[0] > array[1]) ? array[0] : array[1];
      } else {
        max = array[0] + array[1];
      }

    } else {
      for (int i = 0; i <= n - k; i++) {
        int tmp = 0;
        for (int j = i; j < i + k; j++) {
          tmp += array[j];
        }
        if (max < tmp) {
          max = tmp;
        }
      }
    }

    System.out.println(max);
  }
}
