package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2110_공유기설치 {

    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int low = 1;
        int high = array[n - 1] - array[0] + 1;

        while (low < high) {

            int mid = (high + low) / 2;

            if (check(mid) < m) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        System.out.println(low - 1);
    }

    // 가능한 와이파이 연결 상태인지 확인
    public static int check(int value) {
        int lastLocate = array[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            int log = array[i];

            if (log - lastLocate >= value) {
                count++;
                lastLocate = log;
            }
        }

        return count;
    }
}
