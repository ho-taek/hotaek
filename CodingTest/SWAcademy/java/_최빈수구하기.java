import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _최빈수구하기
{
	public static void main(String args[]) throws Exception
	{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // int T = Integer.parseInt(br.readLine());
    for(int i=0; i < 10; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      String[] array = br.readLine().split(" ");
      int[] count = new int[101];
      for(String s : array){
        int index = Integer.parseInt(s);
        array[index] = array[index] + 1;
      }
    }
	}
}