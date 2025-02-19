package 프로그래머스.java.Lv2;

public class _호텔대실 {
    public class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Time t) {
            if (this.start == t.start) {
                return this.end - t.end;
            }
            return this.start - t.start;
        }
    }

    public int solution(String[][] book_time) {
        int answer = 0;

        List<Time> lit = new ArrayList();

        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");

            int s = calTime(start[0], start[1]);
            int e = calTime(end[0], end[1]);

            lit.add(new Time(s, e + 10));
        }

        Collections.sort(lit); // 정렬

        boolean[] check = new boolean[book_time.length];

        int start = 0;
        for (Time t : lit) {
            if (check[start]) {
                start++;
                continue;
            }
            int right = t.end;
            check[start] = true;

            for (int i = start + 1; i < book_time.length; i++) {
                if (check[i])
                    continue;

                if (right <= lit.get(i).start) {
                    check[i] = true;
                    right = lit.get(i).end;
                }
            }
            start++;
            answer++;
        }

        return answer;
    }

    public int calTime(String hour, String minute) {
        int h = Integer.parseInt(hour) * 60;
        int m = Integer.parseInt(minute);

        return h + m;
    }
}
