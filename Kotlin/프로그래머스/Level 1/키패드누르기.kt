// 왼손 * 시작, 오른손 # 시작
// 1, 4, 7 only 왼손, 3, 6, 9 only 오른손
// 가운데 2, 5, 8 ,0 더 가까운 위치의 손가락 사용, 거리가 같다면 주손 이용
// 각 번호를 누른 손가락이 왼손인지 오른손인지 나타내는 문자열을 구하라

// 각 손가락의 위치좌표를 저장할 Pair 랑 left, right,  middle에 있는것들을 저장한 set 이 필요할듯
// 각 번호들의 위치를 지정해놔야할듯
import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        
        var left = setOf<Int>(1, 4, 7)
        var right = setOf<Int>(3, 6, 9)
        var middle = setOf<Int>(2, 5, 8, 0)
        
        var positionMap = mutableMapOf<Int, Pair<Int, Int>>()
        
        positionMap.put(1, Pair(0, 0))
        positionMap.put(2, Pair(0, 1))
        positionMap.put(3, Pair(0, 2))
        positionMap.put(4, Pair(1, 0))
        positionMap.put(5, Pair(1, 1))
        positionMap.put(6, Pair(1, 2))
        positionMap.put(7, Pair(2, 0))
        positionMap.put(8, Pair(2, 1))
        positionMap.put(9, Pair(2, 2))
        positionMap.put(0, Pair(3, 1))
        
        
        
        var leftPos = Pair<Int,Int>(3, 0)
        var rightPos = Pair<Int,Int>(3, 2)
        
        
                
        for(number in numbers) {
            var numberPos = positionMap.getOrDefault(number, Pair(-1,-1))

            if(number in left) {
                answer += "L"
                leftPos = numberPos
            }
            else if (number in right) {
                answer += "R"
                rightPos = numberPos
            }
            else{
                var distanceLeft = abs(numberPos.first-leftPos.first) + abs(numberPos.second-leftPos.second)
                var distanceRight = abs(numberPos.first-rightPos.first) + abs(numberPos.second-rightPos.second)
                
                if(distanceLeft > distanceRight){
                    answer += "R"
                    rightPos = numberPos
                }
                else if (distanceLeft < distanceRight) {
                    answer += "L"
                    leftPos = numberPos
                }
                else{
                    if(hand == "right"){
                        answer += "R"
                        rightPos = numberPos
                    }
                    else {
                        answer += "L"
                        leftPos = numberPos
                    }
                }
            }
        }
        
        
        return answer
    }
}