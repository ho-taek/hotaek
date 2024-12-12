import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드 입력 받기
        char[] colors = new char[5];
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            colors[i] = input[0].charAt(0);
            numbers[i] = Integer.parseInt(input[1]);
        }

        boolean allSameColor = true;
        for (int i = 1; i < 5; i++) {
            if (colors[i] != colors[0]) {
                allSameColor = false;
                break;
            }
        }

        // 숫자 정렬
        Arrays.sort(numbers);
        // 연속적인지 확인
        boolean consecutive = true;
        for (int i = 0; i < 4; i++) {
            if (numbers[i + 1] - numbers[i] != 1) {
                consecutive = false;
                break;
            }
        }

        // 숫자 빈도 체크
        int[] freq = new int[10]; // 1~9만 사용하므로 0은 사용안함
        for (int num : numbers) {
            freq[num]++;
        }

        // 빈도 기반 패턴 파악
        // 최대 빈도, 두 번째로 큰 빈도, 해당 숫자 파악
        int maxCount = 0; // 최대 빈도
        int secondMaxCount = 0; // 두번째로 큰 빈도
        int tripleNum = 0; // 3장 같은 숫자
        int fourNum = 0; // 4장 같은 숫자
        int pairNum1 = 0; // 첫 번째 페어 숫자
        int pairNum2 = 0; // 두 번째 페어 숫자

        List<Integer> pairList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (freq[i] > maxCount) {
                secondMaxCount = maxCount;
                maxCount = freq[i];
            } else if (freq[i] > secondMaxCount) {
                secondMaxCount = freq[i];
            }
        }

        // 4장 같은거, 3장 같은거, 2장 같은거 식별
        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 4) {
                fourNum = i;
            } else if (freq[i] == 3) {
                tripleNum = i;
            } else if (freq[i] == 2) {
                pairList.add(i);
            }
        }

        // 페어가 2개일 수 있으니 정렬
        Collections.sort(pairList);
        if (pairList.size() == 1) {
            pairNum1 = pairList.get(0);
        } else if (pairList.size() == 2) {
            pairNum1 = pairList.get(1); // 더 큰 숫자를 pairNum1으로
            pairNum2 = pairList.get(0);
        }

        int highest = numbers[4]; // 정렬했으니 마지막이 최댓값

        // 규칙에 따라 점수 계산
        // 1. 5장 모두 같은 색 + 연속 숫자
        int score = 0;
        if (allSameColor && consecutive) {
            score = Math.max(score, highest + 900);
        }

        // 2. 4장 숫자 동일
        if (fourNum != 0) {
            score = Math.max(score, fourNum + 800);
        }

        // 3. 풀 하우스 (3장 동일 + 2장 동일)
        if (tripleNum != 0 && pairList.size() == 1) {
            score = Math.max(score, tripleNum * 10 + pairNum1 + 700);
        }

        // 4. 5장 모두 같은 색
        if (allSameColor) {
            score = Math.max(score, highest + 600);
        }

        // 5. 숫자 5장 연속
        if (consecutive) {
            score = Math.max(score, highest + 500);
        }

        // 6. 3장 동일
        if (tripleNum != 0 && pairList.size() == 0) {
            score = Math.max(score, tripleNum + 400);
        }

        // 7. 2장 동일 + 2장 동일 (2페어)
        if (pairList.size() == 2) {
            score = Math.max(score, pairNum1 * 10 + pairNum2 + 300);
        }

        // 8. 2장 동일 (1페어)
        if (pairList.size() == 1 && tripleNum == 0) {
            score = Math.max(score, pairNum1 + 200);
        }

        // 9. 위에 해당하지 않으면
        if (score == 0) {
            score = highest + 100;
        }

        System.out.println(score);
    }
}
