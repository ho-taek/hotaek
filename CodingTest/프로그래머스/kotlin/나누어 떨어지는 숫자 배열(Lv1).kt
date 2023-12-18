class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = arr.filter{it%divisor == 0}.sorted().toIntArray()
        return if(answer.size == 0) intArrayOf(-1) else answer
    }
}