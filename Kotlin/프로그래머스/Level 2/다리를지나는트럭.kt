// 모든 트럭이 다리를 건너려면 최소 몇초?
// 다리에는 트럭이 최대 bridge_length 대 올라갈 수 있음
// 다리는 weight 이하까지의 무게를 견딜 수 있음

import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        
        var bridge = ArrayDeque<Int>()
        var trucks = ArrayDeque<Int>()

        for(i in 0 until bridge_length){
            bridge.offerLast(0)
        }
        
        for(i in 0 until truck_weights.size){
            trucks.offerLast(truck_weights[i])
        }
        
        var endedTrucks = ArrayList<Int>()
        var time = 0
        while(bridge.sum() != 0 || trucks.isNotEmpty()){
            // 1. 빼낼 트럭을 뺴냄
            endedTrucks.add(bridge.pollFirst())
            
            if(bridge.size < bridge_length){ // 다리에 트럭이 들어갈 수 있는 경우    
                // 2. 트럭을 넣을 수 있으면 넣음
                if(trucks.isNotEmpty() && bridge.sum() + trucks.peekFirst() <= weight){
                    bridge.offerLast(trucks.pollFirst())
                }
                else{ // 못 넣으면 빈자리를 넣음
                    bridge.offerLast(0)
                }
            }
            
            time++
        }

        answer = time
        
        
        return answer
    }
}