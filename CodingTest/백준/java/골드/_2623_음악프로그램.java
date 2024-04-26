package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2623_음악프로그램 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] table = new int[n+1];
    boolean[] check = new boolean[n+1];
    List<List<Integer>> graph = new ArrayList<>();
    graph.add(new ArrayList<>());
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList<>());
    }

    //우선순위 큐
    Queue<Integer> pq = new LinkedList<>();

    for(int i = 0 ; i< k ; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int in = Integer.parseInt(st.nextToken());
      pq.offer(in);
      for(int j = 0; j <(a-1); j++){
        int out = Integer.parseInt(st.nextToken());
        table[out]++;
        graph.get(in).add(out);
        in = out;
      }
    }

    bfs(pq, graph, check, table);
  }

  public static void bfs(Queue<Integer> pq, List<List<Integer>> graph, boolean[] check, int[] table){
    Integer q = pq.poll();
    System.out.println(q);

    check[q] = true;
    while(!pq.isEmpty()){
      for(int number : graph.get(q)){
        if(check[number]) continue;

        table[number]--;

        if(table[number] == 0){
          System.out.println(number);
          pq.offer(number);
          check[number] = true;
        }
      }
    }


  }
}
