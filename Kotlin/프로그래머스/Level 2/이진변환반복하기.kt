class Solution {
    var zeroCnt = 0
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        
        var x = s
        var transformCnt = 0
        // binaryTransformation(x)
        
        
        while(x != "1"){
            x = binaryTransformation(x)
            transformCnt++
        }
        answer += transformCnt
        answer += zeroCnt
        return answer
    }
    
    fun binaryTransformation(x:String):String {
        zeroCnt += x.count{it == '0'}
        var newX = Integer.toBinaryString(x.filter{it == '1'}.length)
        
        println(newX)
        
        return newX
    }
}