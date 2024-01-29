package reetcode.java.hard;

public class _42 {
    public static void main(String[] args){
     
    }

    public int trap(int[] height) {
        int left = 0;
   int left_max = height[left];
   int right = height.length-1;
   int right_max = height[right];
   int volume = 0;
   while(left < right){
     if(left_max <= right_max){
       left ++;
       if(left_max < height[left]){
         left_max = height[left];
       }else{
         volume += left_max-height[left];
       }
     }else{
       right --;
       if(right_max < height[right]){
         right_max = height[right];
       }else{
         volume += right_max-height[right];
       }

     }
   }
   return volume;
   }
    
}
