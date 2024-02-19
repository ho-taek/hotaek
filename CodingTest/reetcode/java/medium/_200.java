package reetcode.java.medium;

import java.util.LinkedList;
import java.util.*;

public class _200 {
    public static boolean[][] visited;

    public class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args){

    }
    
    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid.length];


        
    
        return 0;
    }

    public static void bfs(Node start, int size){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);


        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(true){
            Node q = queue.poll();
            visited[q.x][q.y] = true;
            for(int i=0; i < 4; i++){
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
    
                if(nx >=0 && nx < size && ny >=0 && ny < size ){
                    if(visited[nx][ny]){
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

   
    }
}
