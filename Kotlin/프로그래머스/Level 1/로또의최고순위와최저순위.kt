// 1부터45까지 숫자 중 6개 맞추는 복권
// 알아 볼 수 없는 숫자는 0
// 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담기
class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = IntArray(2)
        
        var winSets = win_nums.toSet()
        
        var cntRightNums = 0 // 맞춘 숫자 갯수
        var cntZeros = 0 // 0 의 갯수
        for(number in lottos){
            if(number == 0){
                cntZeros++
            }
            else if (winSets.contains(number)) {
                cntRightNums++
            }
        }
        
        var best = cntRightNums + cntZeros // 최고의 상황
        var worst = cntRightNums // 최악의 상황
        
        
        if(best==0){
            answer[0] = 6
        }
        else{
            answer[0] = 7-best    
        }
        
        if(worst == 0){
            answer[1] = 6
        }
        else{
            answer[1] = 7-worst    
        }
        
        
        
        
        
        return answer
    }
}


// 다른 사람 코드 -> 굉장히 깔끔하다.
class Solution {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return intArrayOf(
                (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
                (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
        ).map { if (it > 6) it - 1 else it }.toIntArray()
    }
}


