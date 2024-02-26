package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14889 {
    static int[][] graph;
    static boolean[] visited;
    static int[] person;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for(int i =0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j <n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        Integer[] start = new Integer[n/2];

        person = new int[n];

        for(int i=0; i <n; i++){
            person[i] = i;
        }

        result = Integer.MAX_VALUE;

        combi(n, 0, 0);
        System.out.println(result);
    }

    static void combi(int n, int depth, int count) {
		if(count == n / 2) {
            calc(n);
			return;
		}
		for(int i = depth; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;	
				combi(n, i + 1, count + 1);	
				visited[i] = false;	
			}
		}
	}

    static void calc(int n){
        int startTeam = 0;
        int linkTeam = 0;

        for(int i=0; i < (n-1); i++){
            for(int j = i+1; j < n; j++){
                if(visited[i] == true && visited[j] == true){
                    startTeam += (graph[i][j] + graph[j][i]);
                }
                else if(visited[i] == false && visited[j] == false){
                    linkTeam += (graph[i][j] + graph[j][i]);
                }
            }
        }
        int abs = Math.abs(startTeam - linkTeam);
        if(result > abs){
            result = abs;
        }
    }
}
