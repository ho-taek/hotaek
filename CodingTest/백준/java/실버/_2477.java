package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;

    for (int i = 0; i < 6; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      switch (a) {
        case 1: {
          one = b;
          break;
        }
        case 2: {
          two = b;
          break;
        }
        case 3: {
          three = b;
          break;
        }
        case 4: {
          four = b;
          break;
        }
      }
    }
    int height = (three > four) ? three : four;
    int weight = (one > two) ? one : two;

    int reHeight = (three > four) ? four : three;
    int reWeight = (one > two) ? two : one;

    int size = height * weight;
    int reSize = reHeight * reWeight;
    System.out.println(height + " " + weight + " " + " " + reHeight + " " + reWeight);
    System.out.println((size - reSize) * n);
  }
}
