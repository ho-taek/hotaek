import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _21608_상어초등학교 {

    static int n;
    static Student[][] array;
    static int[] num;
    static List<Set<Integer>> value;
    static List<Integer> nowList;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static class Student implements Comparable<Student>{
        int sNum;
        int x;
        int y;
        int like;
        int wall;

        public Student(int sNum,int x, int y){
            this.sNum = sNum;
            this.x = x;
            this.y = y;
            this.like = 0;
            this.wall = 0;
        }

        @Override
        public int compareTo(Student o) {
            if(this.like == o.like){
                if(this.wall == o.wall){
                    if(this.x == o.x){
                        return this.y - o.y;
                    }else{
                        return this.x - o.x;
                    }
                }else{
                    return o.wall - this.wall;
                }
            }else{
                return o.like - this.like;
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        array = new Student[n][n];

        
        value = new ArrayList<>();
        num = new int[n*n];
        nowList = new ArrayList<>();

        for(int i = 0; i <= n*n; i++){
            value.add(new HashSet<Integer>());
        }

        //그래프 넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                array[i][j] = new Student(-1,i,j);
            }
        }

        for(int i = 0; i < n*n; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            num[i] = first;
            for(int j = 0; j < 4; j++){
                int tmp = Integer.parseInt(st.nextToken());
                value.get(first).add(tmp);
            }
        }

        //처음
        array[1][1] = new Student(num[0], 1,1);
        nowList.add(num[0]);

        for(int k = 1; k < n*n; k++){
            int sNum = num[k];
            PriorityQueue<Student> pq = new PriorityQueue<>();

            for(int i=0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(array[i][j].sNum != -1) continue;
                    pq.add(setting(i, j, sNum));
                }
            }
            Student result = pq.poll();
            array[result.x][result.y] = result;
        }
        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                int like = calLike(array[i][j]);
                switch (like) {
                    case 1: 
                        answer++;
                        break;
                    case 2: 
                        answer += 10;
                        break;
                    case 3: 
                        answer += 100;
                        break;
                    case 4: 
                        answer += 1000;
                        break;
                    default:
                        break;
                }

            }
        }
        System.out.println(answer);

    }

    // 1. 좋아하는 학생이 많은 경우
    // 2. 비어있는 칸이 가장 많은 칸
    // 3. 행의 번호가 가장 작은 칸

    //sNum -> 학생 번호, 
    public static Student setting(int x, int y, int sNum){
        Student student = new Student(sNum,x,y);

        int like = 0;
        int wall = 0;
        Set<Integer> set = value.get(sNum);
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            int tmp = array[nx][ny].sNum;
            if(set.contains(tmp)){
                like++;
            }else if(tmp == -1){
                wall++;
            }
        }
        student.like = like;
        student.wall = wall;
        return student;
    }

    public static int calLike(Student s){
        int like = 0;
        Set<Integer> set = value.get(s.sNum);
        for(int i = 0; i < 4; i++){
            int nx = s.x + dx[i];
            int ny = s.y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            int tmp = array[nx][ny].sNum;
            if(set.contains(tmp)){
                like++;
            }
        }
        
        return like;
    }
 }
