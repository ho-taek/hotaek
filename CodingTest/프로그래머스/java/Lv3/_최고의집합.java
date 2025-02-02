package 프로그래머스.java.Lv3;

import java.util.Arrays;

public class _최고의집합 {
    public int[] solution(int n, int s) {

        int div = s / n;
        int mod = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, div);
        if (div == 0) {
            return new int[] { -1 };
        }

        int index = 0;
        for (int i = 0; i < mod; i++) {
            answer[index % n] += 1;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
