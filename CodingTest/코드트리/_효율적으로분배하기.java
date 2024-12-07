package 코드트리;

import java.util.*;
import java.io.*;

public class _효율적으로분배하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int forValue = n / 5 + 1;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < forValue; i++) {
            int tmp = n;

            tmp -= 5 * i;

            if (tmp % 3 == 0) {
                answer = Math.min(answer, i + tmp / 3);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
