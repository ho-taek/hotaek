package reetcode.java.medium;

import java.util.LinkedList;
import java.util.*;

public class _200 {


    public static void main(String[] args){

    }
    
    public static int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    result ++;
                }
            }
        }
        return result;
    }

    public static void dfs(int x, int y,  char[][] graph){
        if(x >=0 && y >=0 && x < graph.length && y < graph[0].length && graph[x][y] == '1'){
            graph[x][y] = '0';
            dfs(x,y+1, graph);
            dfs(x, y-1, graph);
            dfs(x-1, y, graph);
            dfs(x+1, y, graph);
        }
        return;
    }
}
