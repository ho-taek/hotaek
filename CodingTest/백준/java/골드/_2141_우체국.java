package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _2141_우체국 {

    public static class City implements Comparable<City> {
        int x;
        int a;

        public City(int x, int a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(City o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long total = 0;

        List<City> city = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            city.add(new City(x, a));
            total += a;
        }
        Collections.sort(city);

        long num = 0;
        for (City c : city) {
            num += c.a;
            if (num >= (total + 1) / 2) {
                System.out.println(c.x);
                return;
            }
        }
    }
}
