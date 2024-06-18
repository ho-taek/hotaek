package 프로그래머스.java.Lv2;

public class _타겟넘버 {
    public static int answer = 0;
    public static boolean[] visited;

    public int solution(int[] numbers, int target) {

        visited = new boolean[numbers.length];

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int tmp, int depth) {
        if (depth == numbers.length) {
            if (tmp == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, tmp + numbers[depth], depth + 1);
        dfs(numbers, target, tmp - numbers[depth], depth + 1);
    }
}
