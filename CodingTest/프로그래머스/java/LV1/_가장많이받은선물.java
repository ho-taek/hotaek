package 프로그래머스.java.LV1;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> index = new HashMap();
        int friendsSize = friends.length;

        // 각각의 번호 넣기
        for (int i = 0; i < friendsSize; i++) {
            index.put(friends[i], i);
        }

        // 주고 받은 것
        int[][] calculate = new int[friendsSize][friendsSize];

        // 주고 받은 것 계산
        for (String i : gifts) {
            String[] giveSend = i.split(" ");
            calculate[index.get(giveSend[0])][index.get(giveSend[1])]++;
        }

        // 선물 지수 배열
        int[] gift = new int[friendsSize];

        // 선물 지수 계산 ->
        for (int i = 0; i < friendsSize; i++) {
            int send = 0;
            int give = 0;

            for (int j = 0; j < friendsSize; j++) {
                // 같을 경우 muzi == muzi
                if (i == j)
                    continue;

                send += calculate[j][i];
                give += calculate[i][j];
            }
            gift[i] = give - send;
        }

        // 선물 받은거 계산
        int[] result = new int[friendsSize];

        for (int i = 0; i < friendsSize; i++) {
            for (int j = i + 1; j < friendsSize; j++) {
                if (calculate[i][j] > calculate[j][i]) {
                    result[i]++;

                } else if (calculate[i][j] == calculate[j][i]) { // 선물 지수 비교
                    if (gift[i] > gift[j]) {
                        result[i]++;
                    } else if (gift[i] < gift[j]) {
                        result[j]++;
                    }
                } else {
                    result[j]++;
                }
            }
        }

        System.out.println(Arrays.toString(result));

        int answer = 0;

        for (int i = 0; i < friendsSize; i++) {
            if (answer < result[i]) {
                answer = result[i];
            }
        }
        return answer;
    }
}
