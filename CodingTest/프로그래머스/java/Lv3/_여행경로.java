package 프로그래머스.java.Lv3;

import java.util.*;

class _여행경로 {
    public static List<String> dfs(List<String> results, Map<String, PriorityQueue<String>> fromTo, String from) {

        while (fromTo.containsKey(from) && !fromTo.get(from).isEmpty()) {
            dfs(results, fromTo, fromTo.get(from).poll());
        }

        results.add(0, from);

        return results;
    }

    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> fromTo = new HashMap<>();

        for (String[] i : tickets) {
            fromTo.putIfAbsent(i[0], new PriorityQueue<>());
            fromTo.get(i[0]).add(i[1]);
        }
        List<String> results = new LinkedList<>();

        dfs(results, fromTo, "ICN");

        return results.toArray(new String[results.size()]);
    }

}