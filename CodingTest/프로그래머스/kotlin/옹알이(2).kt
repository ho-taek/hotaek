class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val check = arrayOf<String>("aya","ye","woo","ma")
        babbling.forEach{ba ->
            var temp = ba
            for(i in check){
                if(temp.contains(i+i)){
                    continue
                } else {
                    temp = temp.replace(i, " ")
                }
            }
            if(temp.replace(" ", "") == "") answer ++
        }
        return answer
    }
}