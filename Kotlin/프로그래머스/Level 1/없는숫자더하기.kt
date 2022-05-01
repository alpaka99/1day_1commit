class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
            
        var numSet = numbers.toSet()
        
        for(i in 0..9){
            if(numSet.contains(i)){
                continue
            }
            else{
                answer += i
            }
        }
        
        return answer
    }
}


// class Solution {
//     fun solution(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()
// }