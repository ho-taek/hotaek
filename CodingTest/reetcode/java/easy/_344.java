package reetcode.java.easy;

public class _344 {
    
    public static void main(String[] args){
        char[] array = {'h','e','l','l','o'};

        reverseString(array);

    }


    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start ++;
            end --;

        }
    }
}
