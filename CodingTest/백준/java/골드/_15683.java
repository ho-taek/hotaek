package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15683 {
    static int[][] graph;
    static List<Integer> store;
    static List<boolean[]> visitedStore;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        store = new ArrayList<>();
        visitedStore = new ArrayList<>();
        for(int i =0; i < n ; i++){
            StringTokenizer sta= new StringTokenizer(br.readLine());
            for(int j=0; j <m; j++){
                int value = Integer.parseInt(sta.nextToken());
                graph[i][j] = value;
                if(value != 0 && value != 6){
                    store.add(value);
                    visitedStore.add(makeVisited(value));
                }
            }
        }
        System.out.println(store);
    }

    public static boolean[] makeVisited(int value){
        if(value == 1){
            return new boolean[4];
        }else if(value == 2){
            return new boolean[2];
        }else if(value == 3){
            return new boolean[4];
        }else if(value == 4){
            return new boolean[4];
        }else{
            return new boolean[1];
        }
    }
}
