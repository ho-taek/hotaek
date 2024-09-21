package 프로그래머스.java.Lv3;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {

        // 그래프
        int[][] graph = new int[board.length][board[0].length];

        int xSize = board.length;
        int ySize = board[0].length;

        for (int i = 0; i < skill.length; i++) {
            // 공격
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int value = skill[i][5];
            if (skill[i][0] == 1) {
                graph[r1][c1] += -value;

                if (c2 + 1 < ySize) {
                    graph[r1][c2 + 1] += value;
                }
                if (r2 + 1 < xSize) {
                    graph[r2 + 1][c1] += value;
                }
                if (r2 + 1 < xSize && c2 + 1 < ySize) {
                    graph[r2 + 1][c2 + 1] += -value;
                }

            } else { // 수비
                graph[r1][c1] += value;

                if (c2 + 1 < ySize) {
                    graph[r1][c2 + 1] += -value;
                }
                if (r2 + 1 < xSize) {
                    graph[r2 + 1][c1] += -value;
                }
                if (r2 + 1 < xSize && c2 + 1 < ySize) {
                    graph[r2 + 1][c2 + 1] += value;
                }
            }
        }

        for (int i = 0; i < xSize; i++) {
            int before = 0;
            for (int j = 0; j < ySize; j++) {
                before += graph[i][j];
                graph[i][j] = before;
            }
        }

        for (int j = 0; j < ySize; j++) {
            int before = 0;
            for (int i = 0; i < xSize; i++) {
                before += graph[i][j];
                graph[i][j] = before;

            }
        }
        int answer = 0;

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                board[i][j] += graph[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
