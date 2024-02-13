package 백준.java.실버;

import java.util.*;
import java.io.*;

public class _17086 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        boolean[][] barray = new boolean[5][4]
        for(int i =0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j < m; j++){
                int x = Integer.parseInt(st.nextToken());
                array[i][j] = x;
                if(x == 1){
                    barray[i][j] = true;
                }
            }
        }
        int[][] answer = new int[n][m];
        int[] dx = {-1,-1,-1,1,1,0,0};
        int[] dy = {-1,0,1,-1,0,1,-1,1};

        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){



            }
        }
    }
    
    public static int bfs(int[] start, boolean[][] graph){
        ArrayDeque deque = new ArrayDeque<>();
        deque.add(start);
        int count = 0;
        graph[start[0]][start[1]] = true;
        while(!deque.isEmpty()){
            int[] array = deque.pollFirst();
            
            for(int i=0 ; i < 8; i++){
                nx = dx[i]

            }

        }
        return 0;
    }
    
}
