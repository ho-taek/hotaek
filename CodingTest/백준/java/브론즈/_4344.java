package 백준.java.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        
        for(int i =0; i < c; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean check = false;
            int mod = 0;
            int add = 0;
            ArrayList<Integer> score = new ArrayList<>();
            while(st.hasMoreTokens()){
                if(check){
                    String tmp = st.nextToken();
                    score.add(Integer.parseInt(tmp));
                    add += Integer.parseInt(tmp);
                }else{
                    mod = Integer.parseInt(st.nextToken());
                    check = true;
                }
            }
            int average = (add/mod);
            double count = 0;
            for(int a : score){
                if(a > average){
                    count ++;
                }
            }
            System.out.printf("%.3f%%\n",(float) (count/mod)*100, "%");
        }


    }
}
