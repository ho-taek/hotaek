package 프로그래머스.java.Lv2;

public class _KAKAO_n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int index = 1;

        while (answer.length() < t) {
            String[] tmp = Integer.toString(num, n).split("");
            for (int i = 0; i < tmp.length; i++) {
                if (index % m == 0) {
                    if (m == p) {
                        answer += tmp[i].toUpperCase();
                    }
                } else {
                    if (index % m == p) {
                        answer += tmp[i].toUpperCase();
                    }
                }
                if (answer.length() >= t) {
                    break;
                }
                index++;
            }
            num++;
        }

        return answer;
    }
}
