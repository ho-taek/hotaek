package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;
public class _14502 {
    static boolean[][] wall;
    static int row;
    static int col;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Node> nodeList;
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
                graph[r][c] = value ;
                wall[r][c] = (value == 0) ? false : true;
                if(value == 2){
                    nodeList.add(new Node(r,c));
                }
            }
        }
    }

    public static void dfs(int depth, int[][] graph, boolean[][] wall){
        if(depth == 3){
            for(Node node : nodeList){
                int[][] tmp = graphChange(graph, node, wall);

            }
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
                        wall[nx][ny] = true;
                        graph[nx][ny] = 2;
                        graphChange(graph, new Node(nx,ny), wall);
                    }
                }
            }
            return graph;
    }


}
