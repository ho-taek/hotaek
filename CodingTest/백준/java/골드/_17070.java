package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 {
    static int[][] graph;
    static int result;
    public class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        dfs(0,1,n,-1);

        System.out.println(result);
    }
    
    // -1 : r, 0 : c , 1 : e
    public static void dfs(int x, int y, int n, int flag){
        if(x == (n-1) && y == (n-1)){
            result ++;
            return ;
        }


            if(flag == -1){
                if(check(x,y,n,2) && graph[x][y+1] == 0 ){
                    dfs(x, y+1, n, -1);
                }
                if(check(x,y,n,3) && edge(x,y,n) && graph[x+1][y+1] == 0 ){
                    dfs(x+1, y+1, n, 1);
                }
                
            }else if(flag == 0) {
                if(check(x,y,n,1) && graph[x+1][y] == 0 ){
                    dfs(x+1, y, n, 0);
                }
                if(check(x,y,n,3) && edge(x,y,n) && graph[x+1][y+1] == 0 ){
                    dfs(x+1, y+1, n, 1);
                }
            }else{
                
                if(check(x,y,n,1) && graph[x+1][y] == 0 ){
                    dfs(x+1, y, n, 0);
                }
                if(check(x,y,n,2) && graph[x][y+1] == 0){
                    dfs(x, y+1, n, -1);
                }
                if(check(x,y,n,3) && edge(x,y,n) && graph[x+1][y+1] == 0){
                    dfs(x+1, y+1, n, 1);
                }
            }
            
    }
    // 0 : (x,y) 1: (x+1, y) 2 : (x, y+1) 3 : (x+1, y+1)
    public static boolean check(int x, int y, int n, int flag){
        if(flag == 0){
            return (x >= 0 && x < n && y >= 0 && y < n);
        }else if(flag == 1){
            return (x+1) >= 0 && (x+1) < n && y >= 0 && y < n;
        }else if(flag == 2){
            return x >= 0 && x < n && (y+1) >= 0 && (y+1) < n;
        }else{
            return (x+1) >= 0 && (x+1) < n && (y+1) >= 0 && (y+1) < n;
        }
    }
    public static boolean edge(int x, int y, int n){

        return check(x,y,n,2) && check(x,y,n,1) &&
        graph[x][y+1] == 0 && graph[x+1][y] == 0 ;
    }
}
