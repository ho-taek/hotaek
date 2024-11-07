package 알고리즘;

import java.io.*;
import java.util.*;

public class _LCA {
    // 인접 리스트를 위한 배열
    static ArrayList<Integer>[] adjacencyList;
    // 각 노드의 깊이를 저장
    static int[] depth;
    // 이진 상승을 위한 부모 배열
    static int[][] parent;
    // 방문 여부를 확인하기 위한 배열
    static boolean[] visited;
    // BFS를 위한 큐
    static Queue<Integer> queue;

    // BFS를 통해 트리의 깊이와 부모 노드를 설정
    static void bfs(int root) {
        visited[root] = true;
        queue.offer(root);
        depth[root] = 0; // 루트의 깊이는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor][0] = current; // 2^0 번째 부모는 직접 부모
                    depth[neighbor] = depth[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // LCA를 찾는 함수
    static int lca(int x, int y) {
        if (depth[x] < depth[y]) {
            // x가 더 깊도록 교환
            int temp = x;
            x = y;
            y = temp;
        }

        // x를 y와 같은 깊이로 맞춤
        for (int i = 16; i >= 0; i--) {
            if (depth[x] - (1 << i) >= depth[y]) {
                x = parent[x][i];
            }
        }

        if (x == y)
            return x;

        // 동시에 올라가며 LCA 찾기
        for (int i = 16; i >= 0; i--) {
            if (parent[x][i] != 0 && parent[x][i] != parent[y][i]) {
                x = parent[x][i];
                y = parent[y][i];
            }
        }

        return parent[x][0];
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드의 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // 트리의 간선 입력
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }

        // 변수 초기화
        depth = new int[n + 1];
        parent = new int[n + 1][17]; // log2(100000) ≈ 17
        visited = new boolean[n + 1];
        queue = new LinkedList<>();

        // 루트 노드(1번 노드)부터 BFS 수행
        bfs(1);

        // 이진 상승을 위한 부모 배열 미리 계산
        for (int j = 1; (1 << j) < n; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] != 0) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                }
            }
        }

        // 쿼리의 개수 입력
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 각 쿼리에 대해 LCA를 계산하여 출력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(lca(x, y)).append('\n');
        }

        // 최종 결과 출력
        System.out.print(sb);
    }
}
