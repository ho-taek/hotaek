package 프로그래머스.java.Lv3;

import java.util.Arrays;

public class _숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(B);
        Arrays.sort(A);
        int aIndex = A.length - 1;
        int bIndex = B.length - 1;

        while (aIndex != -1 && bIndex != -1) {
            if (A[aIndex] < B[bIndex]) {
                aIndex--;
                bIndex--;
                answer++;
            } else {
                aIndex--;
            }
        }

        return answer;
    }
}
