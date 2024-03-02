package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _모의sw_미생물격리 {
    public static class Virus {
        int x, y, count, dir;

        public Virus(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }
    }

    static int n;
    static int m;
    static int k;
    static int[][] now;
    static List<Virus> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // 바이러스 정보 넣기
            virus = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer stg = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stg.nextToken());
                int y = Integer.parseInt(stg.nextToken());
                int count = Integer.parseInt(stg.nextToken());
                int dir = Integer.parseInt(stg.nextToken());
                virus.add(new Virus(x, y, count, dir));
            }

            for (int i = 0; i < m; i++) {
                now = new int[n][n];
                move(now);
                check(now);
            }
            int result = countVirus();
            System.out.println("#" + t + " " + result);
        }
    }

    // 이동 및 약품 닿았을 경우 count 방향 전환
    public static void move(int[][] now) {
        for (int i = 0; i < virus.size(); i++) {
            int dir = virus.get(i).dir;
            int x = virus.get(i).x;
            int y = virus.get(i).y;
            int count = virus.get(i).count;
            if (dir == 1) {
                if (x == 1) {
                    dir = 2;
                    count = count / 2;
                }
                now[x - 1][y]++;
                virus.set(i, new Virus(x - 1, y, count, dir));
            } else if (dir == 2) {
                if (x == n - 2) {
                    dir = 1;
                    count = count / 2;
                }
                now[x + 1][y]++;
                virus.set(i, new Virus(x + 1, y, count, dir));
            } else if (dir == 3) {
                if (y == 1) {
                    dir = 4;
                    count = count / 2;
                }
                now[x][y - 1]++;
                virus.set(i, new Virus(x, y - 1, count, dir));
            } else {
                if (y == n - 2) {
                    dir = 3;
                    count = count / 2;
                }
                now[x][y + 1]++;
                virus.set(i, new Virus(x, y + 1, count, dir));
            }

        }
    }

    // 합쳐지는 것 화긴
    public static void check(int[][] now) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (now[i][j] > 1) {
                    int tmp = 0;
                    List<Virus> removeVirus = new ArrayList<>();
                    int maxCount = Integer.MIN_VALUE;
                    Virus maxVirus = null;
                    for (Virus vi : virus) {
                        if (vi.x == i && vi.y == j) {
                            tmp += vi.count;
                            if (maxCount < vi.count) {
                                maxCount = vi.count;
                                maxVirus = vi;
                            }
                            removeVirus.add(vi);
                        }
                    }
                    if (maxVirus != null) {
                        for (Virus vi : removeVirus) {
                            virus.remove(vi);
                        }
                        maxVirus = new Virus(maxVirus.x, maxVirus.y, tmp, maxVirus.dir);
                        virus.add(maxVirus);
                    }
                }
            }
        }
    }

    // 카운트 세기
    public static int countVirus() {
        int tmp = 0;
        for (Virus vi : virus) {
            tmp += vi.count;
        }
        return tmp;
    }

}
