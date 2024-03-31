package reetcode.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46 {
    static List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();
        int size = nums.length;
        Integer[] output = new Integer[size];
        boolean[] visited = new boolean[size];

        permute(0, output, visited, nums, size);

        return result;

    }

    public static void permute(int depth, Integer[] output, boolean[] visited, int[] array, int size) {
        if (depth == size) {
            result.add(new ArrayList<>(Arrays.asList(output)));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                permute(depth + 1, output, visited, array, size);
                visited[i] = false;
            }
        }
    }
}