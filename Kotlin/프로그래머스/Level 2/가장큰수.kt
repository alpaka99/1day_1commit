// 정수를 이어 붙혀서 만들 수 있는 가장 큰 수를 구하시오
// 모든 경우의 수를 구한 다음 이어 붙힌다 -> 정답은 확실한데 메모리랑 연산 숫자 오바
// 숫자를 string으로 변환 -> 내림차순으로 sorting -> 그 다음 이어붙히기 -> 괜찮을듯?
// 아 이거 그거다 number 가 1000 이하니까 3자리고
// number 4번 반복한거 -> 4자리까지 자르기 -> 이걸 사전순으로 정렬
class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        
        var numStr = ArrayList<Pair<Int, String>>()
        
        if(numbers.maxOf{it} == 0){
            return "0"
        }
        
        for(number in numbers){
            var strNum4 = number.toString().repeat(4).slice(0 until 4)
            numStr.add(Pair(number, strNum4)) // (원래숫자, 늘린숫자) 형태로 넣기
        }
        
        numStr.sortByDescending{it.second}
        
        // var cnt = 0
        numStr.forEach{
            answer = answer + it.first.toString()
        }
        
        // answer = answer.toInt().toString() // 아마 너무 큰 string 으로 된 숫자를 int 로 바꿀려고 해서인듯
        // toBigInteger()? -> yes
        answer = answer.toBigInteger().toString()
        return answer
    }
}