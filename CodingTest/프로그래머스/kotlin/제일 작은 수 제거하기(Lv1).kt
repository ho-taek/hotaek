class Solution {
    fun solution(arr: IntArray): IntArray {
        val size = arr.size
        val answer = if(size == 1)  {
            intArrayOf(-1)
        }else{
            arr.filter{it != arr.minOrNull()}.toIntArray()
        }
       
        return answer
    }
}