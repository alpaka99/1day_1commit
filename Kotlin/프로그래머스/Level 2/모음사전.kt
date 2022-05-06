// 모든 permutation 하면 5*6*6*6*6 => 몇개 안됨. 그냥 모든 permutation 을 구해버리는것도 괜찮을듯?
class Solution {
    var strSet = mutableSetOf<String>()
    var alphaList = arrayOf<String>("A", "E", "I", "O", "U")
    
    fun solution(word: String): Int {
        var answer = 0
        
        
        for(i in 1..5){
            permutation(i, "")
        }
        
        var strList = strSet.toList().sorted()
        
        for(i in 0 until strList.size){
            if(strList[i] == word){
                answer = i+1
                break
            }
        }
        
        return answer
    }
    
    fun permutation(size:Int, curString:String):Unit{
        if(curString.length == size){
            strSet.add(curString)
            return
        }
        
        var newString = curString
        for(i in 0 until 5){
            newString = curString + alphaList[i]
            permutation(size, newString)
            newString = newString.dropLast(1)
        }
    }
    
}