package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _14502 {
    static boolean[][] wall;
    static int row;
    static int col;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Node> nodeList;
    static boolean[][] visited;
    static int max;
    static int[][] tmpGraph;
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

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int[][] graph = new int[row][col];
        wall = new boolean[row][col];
        nodeList = new ArrayList<>();

        for(int r=0; r < row ; r++){
            StringTokenizer sta = new StringTokenizer(br.readLine());
            for(int c=0; c < col; c++){
                int value = Integer.parseInt(sta.nextToken());
                graph[r][c] = value;
                wall[r][c] = (value == 0) ? false : true;
                if(value == 2){
                    nodeList.add(new Node(r,c));
                }
            }
        }
        tmpGraph = new int[row][col];
        max = Integer.MIN_VALUE;
        dfs(0, graph, wall);

        System.out.println(max);
        
    }

    public static void dfs(int depth, int[][] graph, boolean[][] wall){
  
        if(depth == 3){
            visited = new boolean[row][col];
            for(int i=0; i < row; i++){
                for(int j=0; j <col; j++){
                    tmpGraph[i][j] = graph[i][j];
                }
            }
            for(Node node : nodeList){
                tmpGraph = graphChange(tmpGraph, node, wall);
            }

            System.out.println("확인여");
            for(int i=0; i< row; i++){
                System.out.println(Arrays.toString(tmpGraph[i]));
            }
            System.out.println();

            getCount(tmpGraph);
            return;
        }

        for(int r =0; r < row ; r++){
            for(int c=0; c < col; c++){
                if(!wall[r][c]){
                    wall[r][c] = true;
                    graph[r][c] = 1;
                    dfs(depth+1, graph, wall);
                    wall[r][c] = false;
                    graph[r][c] = 0;
               
                }
            }
        }
    }

    public static int[][] graphChange(int[][] graph, Node start, boolean[][] wall){
            for(int i =0; i < 4; i++){
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];
    
                if(nx >=0 && nx < row && ny >=0 && ny < col){
                    if(graph[nx][ny] == 0){
                        graph[nx][ny] = 2;
                        graphChange(graph, new Node(nx,ny), wall);
                    }
                }
            }
            return graph;
    }

<<<<<<< Updated upstream

=======
    public static void getCount(int[][] graph){
        boolean[][] visited = new boolean[row][col];
        for(int i =0; i < row ; i++){
            for(int j=0; j < col ; j++){
                if(graph[i][j] == 0 && !visited[i][j]){
                    int result = bfs(graph, new Node(i,j));
                    if(max < result){
                        max = result;
                    }
                }
            }
        }
    }

    public static int bfs(int[][] graph, Node start){
        int tmp = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Node q = queue.poll();

            for(int i=0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col){
                    if(!visited[nx][ny] && graph[nx][ny] == 0){
                        queue.offer(new Node(nx,ny));
                        visited[nx][ny] = true;
                        tmp ++;
                    }
                }
            }

        }
        return tmp;
    }
>>>>>>> Stashed changes
}
