import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int) (Math.random() * 30));

      boolean[] visited = new boolean[4];


      comb(visited, 0,4);
    }
  
    public static void comb(boolean[] visited, int idx, int n){
      if(idx == n){
        System.out.println(Arrays.toString(visited));
        return;
      }
      visited[idx] = true;
      comb(visited, idx+1, n);
      visited[idx] = false;
      comb(visited, idx+1, n);
    }

}