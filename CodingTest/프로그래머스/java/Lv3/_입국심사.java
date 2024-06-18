package 프로그래머스.java.Lv3;

public class _입국심사 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            
            long start = 1;
            long end = (long) times[times.length-1] * n;
            
            
            while(start < end){
                long mid = (start+end)/2;
                
                long sum = 0;
                for(int time : times){
                    sum += mid/time;
                }
                
                if(sum >= n){
                    answer = mid;
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            
            
            return answer;
        }
    }
}
