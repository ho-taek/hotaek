class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        val length = phone_number.length
        for(i in 0 until length){
            if(i < length-4){
                answer += "*"
            }else{
                answer += phone_number[i]
            }
        }
        return answer
    }
}