package 프로그래머스.java.Lv3;

import java.util.*;

public class _보석쇼핑 {
    public int[] solution(String[] gems) {

        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalGemCount = gemTypes.size();

        Map<String, Integer> gemCountMap = new HashMap<>();
        int left = 0, right = 0, minStart = 0, minLength = Integer.MAX_VALUE;

        while (right < gems.length) {
            gemCountMap.put(gems[right], gemCountMap.getOrDefault(gems[right], 0) + 1);
            right++;

            while (gemCountMap.size() == totalGemCount) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                gemCountMap.put(gems[left], gemCountMap.get(gems[left]) - 1);
                if (gemCountMap.get(gems[left]) == 0) {
                    gemCountMap.remove(gems[left]);
                }
                left++;
            }
        }

        return new int[] { minStart + 1, minStart + minLength };
    }
}
