package reetcode.java.easy;

public class _125 {

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        

      
    }

    public static Boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end --;
            }else{
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start ++;
                end --;
            }
        }
        return true;
    }
}
