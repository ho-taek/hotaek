package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17836_공주님을구해라 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int[][] graph;
    static int n;
    static int m;
    static int T;
    static int answer;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        answer = T+1;
        graph = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][m];

        dfs(visited, 0,0, false, 0);
        if(answer > T){
            System.out.println("Fail");
        }else{
            System.out.println(answer);
        }
    }

    public static void dfs(boolean[][] visited, int x, int y, boolean sword, int t){
        if(t > T){
            return;
        }

        if(x == (n-1) && y == (m-1)){
            if(t < answer){
                answer = t;
            }
        }

        for(int i = 0; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            if(!sword && graph[nx][ny] == 1) continue;

            if(visited[nx][ny]) continue;

            if(graph[nx][ny] == 2){
                sword = true;
            }

            visited[nx][ny] = true;
            dfs(visited, nx,ny, sword, t+1);
            visited[nx][ny] = false;
        }



    }
}
