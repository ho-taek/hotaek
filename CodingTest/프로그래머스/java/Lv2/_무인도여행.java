package 프로그래머스.java.Lv2;

import java.util.*;

class Solution {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] check;

    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList();

        check = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] cArray = maps[i].toCharArray();
            for (int j = 0; j < maps[0].length(); j++) {
                if (cArray[j] == 'X' || check[i][j])
                    continue;

                int cnt = cArray[j] - '0';

                answer.add(bfs(new Node(i, j, cnt), maps));
            }

        }
        if (answer.size() == 0) {
            return new int[] { -1 };
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int bfs(Node start, String[] maps) {
        Queue<Node> queue = new LinkedList();
        queue.offer(start);
        check[start.x][start.y] = true;
        int count = start.cnt;

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + q.x;
                int ny = dy[i] + q.y;

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length())
                    continue;

                char[] c = maps[nx].toCharArray();

                if (c[ny] == 'X' || check[nx][ny])
                    continue;

                int tmp = c[ny] - '0';

                queue.offer(new Node(nx, ny, tmp));
                check[nx][ny] = true;
                count += tmp;
            }

        }

        return count;
    }
}
