package reetcode.java.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(results, candidates, target, 0, new ArrayDeque<>());

        return results;
    }

    public void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(results, candidates, target - candidates[i], i, path);
            path.removeLast();
        }

    }
}
