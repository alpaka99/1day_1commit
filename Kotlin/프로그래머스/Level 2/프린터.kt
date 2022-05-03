// 인쇄 대기목록의 가장 앞을 꺼냄
// 나머지 인쇄 대기 목록에서 J 보다 중요도가 높은 문서가 한개라도 있으면 J 를 대기목록 가장 끝으로 보냄
// 그렇지 않으면 J 를 인쇄

// deque 로 인쇄 대기 목록 만듬
// pair 로 (알파벳, 우선순위) 를 넣음
// deque 를 돌면서 우선순위가 가장 낮은 값을 찾음
// 맨앞을 꺼냈을떄 가장 낮은 우선순위와 같으면 그대로 탈출
// 아니면 다시 deque 맨 끝에 넣기
// deque 가 empty 일떄까지 반복
// 내가 인쇄를 요청한 목록의 순서 출력

import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        
        var printer = ArrayDeque<Pair<Char, Int>>()
        
        var myAlpha = ' '
        
        for(i in 0 until priorities.size){
            var curAlpha = (i+'A'.toInt()).toChar()
            var newPair = Pair(curAlpha, priorities[i])
            printer.offerLast(newPair)
            
            if(i == location){
                myAlpha = curAlpha
            }
        }
        // println(printer)
        
        var turn = 0
        base@ while(printer.isNotEmpty()){
            var maxVal = printer.maxOf{it.second}
            
            var j = printer.pollFirst()
            
            if(j.second == maxVal){ // 우선순위가 최상위인 작업이면
                turn++
                if(j.first == myAlpha){ // 내가 찾던게 출력된거면
                    answer = turn
                    break@base // printer 작업을 그냥 빠져나가버리기~
                }
            }
            else{ // 우선순위가 최상위가 아니면
                printer.offerLast(j) // 다시 넣음
            }
        }
        
        
        return answer
    }
}