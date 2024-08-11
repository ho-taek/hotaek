package 백준.java.실버;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11053_가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] d = new int[n + 1];
        int[] v = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = 1;
        v[1] = arr[1];
        int lastIndex = 1;

        for (int i = 2; i <= n; i++) {
            if (v[lastIndex] < arr[i]) {
                d[lastIndex + 1] = d[lastIndex] + 1;
                v[lastIndex + 1] = arr[i];
                lastIndex++;
                continue;
            }

            for (int j = 0; j < lastIndex; j++) {
                if (v[j] == arr[i]) {
                    break;
                }

                if (v[j] < arr[i] && v[j + 1] > arr[i]) {
                    v[j + 1] = arr[i];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(v));
        System.out.println(d[lastIndex]);
    }
}
