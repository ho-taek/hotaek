class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        
    
        val sizeX = arr1.size
        val sizeY = arr1[0].size
        var answer = Array(sizeX,{IntArray(sizeY)})
        for(i in 0 until sizeX){
            for(j in 0 until sizeY){
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }
        return answer
    }
}