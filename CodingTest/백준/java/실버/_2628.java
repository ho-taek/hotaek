package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class _2628 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int c = Integer.parseInt(br.readLine());

    List<Integer> listA = new ArrayList<>();
    List<Integer> listB = new ArrayList<>();
    listA.add(0);
    listB.add(0);
    for (int i = 0; i < c; i++) {
      StringTokenizer str = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());
      if (a == 0) {
        listA.add(b);
      } else {
        listB.add(b);
      }
    }

    listA.add(m);
    listB.add(n);

    Collections.sort(listA);
    Collections.sort(listB);

    int aMax = 0;
    for (int i = 1; i < listA.size(); i++) {
      int check = (listA.get(i) - listA.get(i - 1));
      if (aMax < check) {
        aMax = check;
      }
    }

    int bMax = 0;

    for (int i = 1; i < listB.size(); i++) {
      int check = (listB.get(i) - listB.get(i - 1));
      if (bMax < check) {
        bMax = check;
      }
    }
    System.out.println(aMax);
    System.out.println(bMax);
    System.out.println(aMax * bMax);

  }
}
