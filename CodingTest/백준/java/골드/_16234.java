package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _16234 {
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] graph;
    static boolean[][] visited;
    static boolean flag;
    static List<Node> calc;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0; i < n; i++){
            StringTokenizer sta = new StringTokenizer(br.readLine());
            for(int j=0; j < n; j++){
                graph[i][j] = Integer.parseInt(sta.nextToken());
            }
        }
        flag = false;

        int day = 0;
        while(!flag){
            flag = true;
            for(int i=0; i < n; i++){
                System.out.println(Arrays.toString(graph[i]));
            }
            visited = new boolean[n][n];
            for(int i=0; i <n; i++){
                for(int j=0; j <n; j++){
                    if(!visited[i][j]){
                        for(int a=0; a < 4; a++){
                            int nx = i + dx[a];
                            int ny = j + dy[a];
                            if(nx >=0 && nx < n && ny >=0 && ny < n){
                                
                                int abs = Math.abs(graph[i][j] - graph[nx][ny]);
                                if(abs <= r && abs >= l){
                                    int tmp = bfs(new Node(i,j),n,r,l);
                                    int cal = tmp / calc.size();
                                    for(Node node : calc){
                                        graph[node.x][node.y] = cal;
                                    }
                                    
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(!flag){
                day ++;
            }
        }
        System.out.println(day);
    }

    public static int bfs(Node start, int n, int r, int l){
        flag = false;
        int tmp = 0;
        Queue<Node> queue = new LinkedList<>();
        calc = new ArrayList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        calc.add(start);
        tmp += graph[start.x][start.y];

        while(!queue.isEmpty()){
            
            Node q = queue.poll();
            
            for(int a=0; a < 4; a++){
                int nx = q.x + dx[a];
                int ny = q.y + dy[a];
                if(nx >=0 && nx < n && ny >=0 && ny < n && !visited[nx][ny]){
                    int abs = Math.abs(graph[q.x][q.y] - graph[nx][ny]);
                    if(abs <= r && abs >= l){
                        tmp += graph[nx][ny];
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx,ny));
                        calc.add(new Node(nx,ny));
                    }
                }
            }
        }
        return tmp;
    }
}
