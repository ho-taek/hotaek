package reetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 연습 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            while (st.hasMoreTokens()) {
                System.out.println("답" + Integer.parseInt(st.nextToken()));

            }

        }
    }
}
