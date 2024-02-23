package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2589 {
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new String[n][m];
        visited = new boolean[n][m];

        for(int i=0; i < n; i++){
            String[] array = br.readLine().split("");
            for(int j=0; j < m; j++){
                graph[i][j] = array[j];
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i <n; i++){
            for(int j=0; j <n; j++){
                int t = 0;
                if(!visited[i][j] && graph[i][j].equals("L")){
                    t = bfs(new Node(i,j), n, m);
                }
                if(answer < t){
                    answer = t;
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(Node start, int n, int m){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        int tmp = 0;
        while(!queue.isEmpty()){
            Node q = queue.poll();
            
            for(int i=0; i <4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx >=0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny] && graph[nx][ny].equals("L")){
                        tmp ++;
                        queue.offer(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return tmp;
    }
}
