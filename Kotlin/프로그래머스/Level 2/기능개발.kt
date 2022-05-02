import java.util.*

var deque = ArrayDeque<Pair<Int, Int>>()

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = ArrayList<Int>()
        
        
        
        for(i in 0 until progresses.size){
            deque.offer(Pair(progresses[i], speeds[i]))
        }
        
        
        while(deque.isNotEmpty()){
            var cnt = 0
            for(i in 0 until deque.size){
                var oldPair = deque.pollFirst()
                var newPair = Pair(oldPair.first+oldPair.second, oldPair.second)
                deque.offerLast(newPair)
            }
            
            while(deque.peekFirst().first >= 100){
                deque.pollFirst()
                cnt++
                if(deque.isEmpty()){
                    break
                }
            }
            answer.add(cnt)
        }
        

        
        return answer.filter{it != 0}.toIntArray()
    }
}