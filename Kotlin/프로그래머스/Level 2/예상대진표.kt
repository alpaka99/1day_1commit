// 처음 라운드에 A번 참가자와 B번 참가자가 언제 만나는지 궁금
// N 이 엄청 큼 -> 보통 알고리즘으로는 안됨
class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
    
        var A = a
        var B = b
        var cnt = 0
        while(A != B){
            if(A % 2 == 0){
                A = A / 2
            }
            else {
                A = (A / 2) +1
            }
            
            if(B % 2 == 0){
                B = B / 2
            }
            else {
                B = (B / 2) +1
            }
            cnt++
            }
            
        answer = cnt
        return answer
    }
}