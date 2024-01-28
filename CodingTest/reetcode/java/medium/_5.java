package reetcode.java.medium;

public class _5 {
    
    public static void main(String[] args){
        String st = "cbbd";

        System.out.println(longestPalindrome(st));

    }

    public static String longestPalindrome(String s) {
        int idx = s.length()-1;
        int max = 0;
        String result = "";
        for(int i = 0 ; i < idx; i++){
            int j = i+max;
            while(j <= idx){
                String sub = s.substring(i, j+1);
                if(isPalindromic(sub) && sub.length() > max){
                    result = new String(sub);
                    max = sub.length();
                }
                j++;
            }
        }

        return result;
    }

    public static boolean isPalindromic(String s){
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
