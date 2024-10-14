package 알고리즘;

import java.io.IOException;
import java.util.*;

public class _LIS_binarySearch {

    public static int lowerBound(int[] array, int value, int s, int e) {
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (value <= array[mid]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;

    }

    public static void main(String[] args) throws IOException {
        int arr[] = { 1, 6, 3, 4, 2, 7, 8, 5 };
        int lis[] = new int[8];

        int cnt = 0;
        lis[cnt++] = arr[0];

        for (int i = 1; i < 8; i++) {
            if (lis[cnt - 1] < arr[i]) {
                lis[cnt++] = arr[i];
            } else {
                int idx = lowerBound(lis, arr[i], 0, cnt);
                lis[idx] = arr[i];
            }
        }
    }
}
