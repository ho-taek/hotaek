package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _모의sw_벌꿀채취 {
    static int[][] graph;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for(int i=0; i < n; i++){
            StringTokenizer sta = new StringTokenizer(br.readLine());
            for(int j=0; j < n; j ++){
                graph[i][j] = Integer.parseInt(sta.nextToken());
            }
        }
    }
}
