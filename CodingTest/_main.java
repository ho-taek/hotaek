import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];

        int index = 0;
        while (st.hasMoreTokens()) {
            array[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        int result = 0;
        for (int i = 2; i < n - 2; i++) {
            int leftLeft = array[i] - array[i - 2];
            int left = array[i] - array[i - 1];
            int rightRight = array[i] - array[i + 1];
            int right = array[i] - array[i + 2];
            if (leftLeft <= 0 || left <= 0 || rightRight <= 0 || right <= 0) {
                continue;
            } else {
                int[] tmp = { leftLeft, left, right, rightRight };
                Arrays.sort(tmp);
                result += tmp[0];
            }
        }
        System.out.printf("#%s %s", 1, result);
    }

}
