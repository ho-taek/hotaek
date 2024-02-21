import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 {
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ");
        int n = Integer.parseInt(start[0]);
        int r =  Integer.parseInt(start[1]);

        int[] array = new int [n];
        for(int i =0; i < n; i++){
            array[i] = i+1;
        }
        boolean[] visited = new boolean[n];
        int[] output = new int[r];
        perm(array, output, visited, 0, n, r);
    }

    public static void perm(int[] array, int[] output, boolean[] visited, int depth,int n, int r){
        if(depth == r){
            print(output, r);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = array[i];
                perm(array, output, visited, depth+1, n, r);
                visited[i] = false;
            }
           
        }
    }

    public static void print(int[] output, int r){
        for(int i=0; i < r; i++){
            System.out.print(output[i]+" ");
        }
        System.out.print("\n");
    }
}
