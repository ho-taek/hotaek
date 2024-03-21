import java.io.*;
import java.util.*;

public class Solution {
    static boolean[] visited;
    public static void main(String[] args) {
       visited = new boolean[5];
        for(int i =0; i < 5; i ++){
            visited[2] = true;
            if(!visited[i]){
                System.out.println("트루! " + i);
            }
        }
    }

    public void dfs(){
        visited[2] = true;

    }

}
