package 프로그래머스.java.Lv2;

import java.util.HashSet;

public class _연속부분수열합의개수 {
    public int solution(int[] elements) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int value = 0;
                for (int k = j; k < j + i; k++) {
                    value += elements[k % elements.length];
                }
                set.add(value);
            }
        }

        return set.size();
    }
}
