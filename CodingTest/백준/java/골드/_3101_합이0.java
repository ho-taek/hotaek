import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3101_합이0 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] person = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i <n; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(person);
        System.out.println(Arrays.toString(person));
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(person[i] > 0 || person[n-1] <=0){
                break;
            }
            
            int left = i+1;
            int right = n-1;

            //반대가 나와야 0이됨.
            int check = person[i]*-1;
            boolean flag = (i != n-1);

            int init = i+1;
            while(flag){
                

                if(init == n-1){
                    break;
                }
                if(left >= right){
                    left = ++init;
                    right = n-1;
                }

                if(left == n-1) break;

                int tmp = person[left] + person[right];

                if(check < tmp){
                    right--;
                }else if(check > tmp){
                    left++;
                }else{
                    System.out.println(i + " " + left + " " +right);
                    System.out.println(person[i]+" " + person[left]+ " " + person[right]);
                    right--;
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
}

