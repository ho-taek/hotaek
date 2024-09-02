package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1094_막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < 7; i++) {
            if ((n & (1 << i)) > 0) {
                System.out.println(i + " , " + (n & (1 << i)));
                result++;
            }

        }
        System.out.println(result);
    }
}
