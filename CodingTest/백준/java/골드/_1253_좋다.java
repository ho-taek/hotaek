package 백준.java.골드;


import java.io.*;
import java.util.*;

public class _1253_좋다 {
    

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] graph = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = graph[left] + graph[right];

                if (sum == graph[i]) { 
                    answer++;
                    break;
                } else if (sum < graph[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }

    
}
