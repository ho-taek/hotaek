import java.io.*;
import java.util.*;

public class Solution {
    static boolean[] visited;
    public static void main(String[] args) {
<<<<<<< Updated upstream
      double a = 1.46;
      System.out.println(Math.round(a));
=======
        System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int) (Math.random() * 30));
        Integer[] arr = new Integer[] { 5, 5, 128, 128, 400, 400 };
        for (int i = 0; i < 6; i += 2) {
            if (arr[i].equals(arr[i + 1])) {
                System.out.println("~~");
            } else {
                System.out.println("!!");
            }
        }
>>>>>>> Stashed changes
    }

    public void dfs(){
        visited[2] = true;

    }

}