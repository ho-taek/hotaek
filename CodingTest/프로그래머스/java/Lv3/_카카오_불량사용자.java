package 프로그래머스.java.Lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _카카오_불량사용자 {
    public int solution(String[] user_id, String[] banned_id) {

        List<List<Integer>> candidate = new ArrayList();

        for (String s : banned_id) {
            List<Integer> can = new ArrayList();
            for (int i = 0; i < user_id.length; i++) {
                if (isMatch(user_id[i], s)) {
                    can.add(i);
                }
            }
            candidate.add(can);
        }
        boolean[] visited = new boolean[user_id.length];
        Set<String> dup = new HashSet();
        dfs(0, candidate, visited, dup, new ArrayList());

        return dup.size();

    }

    public static void dfs(int index, List<List<Integer>> candidate, boolean[] visited,
            Set<String> dup, List<Integer> selected) {

        if (index == candidate.size()) { // 인덱스가 전체 사이즈랑 동일해졌을 때,
            List<Integer> sortedList = new ArrayList(selected);
            Collections.sort(sortedList);
            StringBuilder sb = new StringBuilder();
            for (int num : sortedList) {
                sb.append(num);
            }
            dup.add(sb.toString());
            return;
        }

        for (int userId : candidate.get(index)) {
            if (!visited[userId]) {
                visited[userId] = true;
                selected.add(userId);
                dfs(index + 1, candidate, visited, dup, selected);
                visited[userId] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }

    private boolean isMatch(String user, String banned) {
        // 길이 비교
        if (user.length() != banned.length())
            return false;
        for (int i = 0; i < user.length(); i++) {
            char b = banned.charAt(i);
            if (b == '*')
                continue;
            if (user.charAt(i) != b)
                return false;
        }
        return true;
    }
}
