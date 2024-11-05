package 백준.java.실버;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _1946_신입사원 {

    public static class Person implements Comparable<Person> {

        int first;
        int second;

        Person(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Person o) {
            return this.first - o.first;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Person> person = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                person.add(new Person(a, b));
            }
            int answer = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                Person p = person.poll();
                if (p.second < minValue) {
                    answer++;
                    minValue = p.second;
                }

            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
