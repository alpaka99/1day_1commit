class Solution {
    var cnt = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        dfs(numbers, target, 0, 0)
        answer = cnt
        return answer
    }
    
    fun dfs(numbers: IntArray, target:Int, sum:Int, level:Int):Unit {
        if(level == numbers.size){
            if(sum == target){
                cnt++
            }
            return
        }
        
        dfs(numbers, target, sum+numbers[level], level+1)
        dfs(numbers, target, sum-numbers[level], level+1)
        
    }
}