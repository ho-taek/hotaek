package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1459_걷기 {
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long distance = x+y;
        long answer;

        if(w*2 >=  s){
            if(distance % 2 == 0){ //짝수 일때
                answer = Math.max(x, y)*s; //대각선 만으로만 이동
            }else{ //홀수 일때
                answer = (Math.max(x, y)-1)*s + w;
            }
            long tmp = Math.min(x, y)*s + Math.abs(x-y)*w;
            answer = Math.min(answer, tmp);
        }else{ // 대각선보다 작을 때
            answer = distance * w;
        }
        
        System.out.println(answer);
    }

}
