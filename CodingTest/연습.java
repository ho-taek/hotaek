import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 연습{

    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String str = br.readLine();
       StringTokenizer strTokenizer = new StringTokenizer(str);

       System.out.println(str);

    }
}