package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _2023_신기한소수 {
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        int[] prime = { 2, 3, 5, 7 };
        for (int p : prime) {
            find(p, 1);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int num, int digit) throws IOException {
        if (digit == n) {
            bw.write(num + "\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                find(next, digit + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
