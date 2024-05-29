package 프로그래머스.java.Lv2;

public class _n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int index = 0;
        for (long i = left; i <= right; i++) {
            long quotient = i / n;
            long remainder = i % n;

            if (quotient < remainder) {
                answer[index] = (int) remainder + 1;
            } else {
                answer[index] = (int) quotient + 1;
            }
            index++;
        }

        return answer;
    }
}
