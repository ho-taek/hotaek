import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int[][] array = new int[100][100];
        for (int i = 0; i < 100; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 && array[i][j] == 1) {
                    list.add(j);
                }
            }
        }
        int result = 0;
        // 돌림
        for (int c : list) {
            // 우측
            System.out.println(c);
            int dx = 1;
            int dy = c;
            int flag = 0;
            while (true) {
                // 우측
                if ((dy + 1) <= 99 && array[dx][dy + 1] == 1 && (flag == 0 || flag == 1)) {
                    dy = dy + 1;
                    flag = 1;
                } else if (((dy - 1) >= 0) && array[dx][dy - 1] == 1 && (flag == 0 || flag == 2)) {
                    dy = dy - 1;
                    flag = 2;
                }

                if (dx <= 98 && array[dx + 1][dy] == 1 || array[dx + 1][dy] == 2) {
                    flag = 0;
                    dx = dx + 1;
                }

                if (dx == 99) {
                    if (array[dx][dy] == 2) {
                        result = c;
                    }
                    break;
                }
            }
            if (result != 0) {
                break;
            }

        }
        System.out.println("#" + n + " " + result);
    }

}
