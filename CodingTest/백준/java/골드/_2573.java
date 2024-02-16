package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2573 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] array = new int[n][m];

    for (int i = 0; i < n; i++) {
      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        array[i][j] = Integer.parseInt(sta.nextToken());
      }
    }

  }
}
