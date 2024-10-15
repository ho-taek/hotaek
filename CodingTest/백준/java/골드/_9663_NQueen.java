package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9663_NQueen {

    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        count = 0;
        int[] board = new int[n];

        dfs(board, 0);

        System.out.println(count);
    }

    public static void dfs(int[] board, int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(board, row, i)) {
                board[row] = i;
                dfs(board, row + 1);
            }
        }

    }

    public static boolean check(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

}
