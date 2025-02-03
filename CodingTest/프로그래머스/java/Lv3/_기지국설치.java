package 프로그래머스.java.Lv3;

public class _기지국설치 {
    public int solution(int n, int[] stations, int w) {

        int div = 2 * w + 1;

        int left = stations[0] - w;
        int right = stations[0] + w;
        int answer = 0;
        if (left > 1) {
            answer = getCount(div, left - 1);
        }

        for (int i = 1; i < stations.length; i++) {
            left = stations[i] - w;
            if (left - right > 1) {
                answer += getCount(div, left - (right + 1));
            }
            right = stations[i] + w;
        }

        if (right < n) {
            answer += getCount(div, n - right);
        }

        return answer;
    }

    public static int getCount(int div, int minus) {
        int result = 0;

        result += minus / div;
        if (minus % div != 0) {
            result += 1;
        }
        return result;
    }
}
