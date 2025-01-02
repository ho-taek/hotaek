package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2096_내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        int[] tempMax = new int[3];
        int[] tempMin = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] row = new int[3];
            for (int j = 0; j < 3; j++) {
                row[j] = Integer.parseInt(st.nextToken());
            }

            tempMax[0] = row[0] + Math.max(maxDp[0], maxDp[1]);
            tempMax[1] = row[1] + Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
            tempMax[2] = row[2] + Math.max(maxDp[1], maxDp[2]);

            tempMin[0] = row[0] + Math.min(minDp[0], minDp[1]);
            tempMin[1] = row[1] + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
            tempMin[2] = row[2] + Math.min(minDp[1], minDp[2]);

            System.arraycopy(tempMax, 0, maxDp, 0, 3);
            System.arraycopy(tempMin, 0, minDp, 0, 3);
        }

        int maxScore = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minScore = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(maxScore + " " + minScore);

    }

}
