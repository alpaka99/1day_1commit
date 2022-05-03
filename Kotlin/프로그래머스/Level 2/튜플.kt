// n 개의 요소를 가진 순서를 따르는 모음을 (a1, a2, ...) 튜플이라 표현
// 튜플은 중복된 원소 가능
// 정해진 순서가 있으며 원소의 순서가 다르면 다른 튜플
// 원소의 갯수는 유한

// 중복되는 원소가 없는 튜플 이 주어질때, 앞 원소부터 {{a1}, {a1, a2}, {a1, a2, a3} ... 라고 집합으로 표현 가능
// 이 집합은 원소가 바뀌어도 상관 x e.g. {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}} -> 짧은 원소 부터 세야될듯?
// 특정 튜플을 표현하는 집합 s 가 주어질떄, s 가 표현하는 튜플을 배열에 담아 return
class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        
        
        
        var s1 = s.slice(1 until s.length-1).split("},").map{it.trim('{').trim('}').split(",").map{it.toInt()}}.sortedBy{it.size}
        
        var numSet = mutableSetOf<Int>()
        
        for(elem in s1){
            for(num in elem){
                if(numSet.contains(num)){
                    continue
                }
                else{
                    answer += num
                    numSet.add(num)
                }
            }
        }
        return answer
    }
}