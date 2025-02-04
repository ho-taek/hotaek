package 프로그래머스.java.Lv3;

public class _스티커모으기_2 {
    public int solution(int sticker[]) {
        int answer = 0;
        int size = sticker.length;

        if (size == 1) {
            return sticker[0];
        }
        if (size == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        // 0번째 부터 뜯을 때
        int[] dpZero = new int[size];
        dpZero[0] = sticker[0];
        dpZero[2] = dpZero[0] + sticker[2];
        for (int i = 3; i < size; i++) {
            dpZero[i] = Math.max(dpZero[i - 2], dpZero[i - 3]) + sticker[i];
        }
        dpZero[size - 1] = 0;

        // 1번째 부터 뜯을 때
        int[] dpOne = new int[size];
        dpOne[1] = sticker[1];
        dpOne[2] = sticker[2];
        for (int i = 3; i < size; i++) {
            dpOne[i] = Math.max(dpOne[i - 2], dpOne[i - 3]) + sticker[i];
        }

        for (int i = 0; i < size; i++) {
            answer = Math.max(answer, Math.max(dpZero[i], dpOne[i]));
        }

        return answer;
    }
}
