// 어떤 문자열 s 가 주어졌을떄 s 를 왼쪽으로 x 만큼 회전시키면 올바른 문자열인 x 의 갯수
import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        for(x in 0 until s.length){
            var left = s.slice(0..x)
            var right = s.slice(x+1..s.length-1)
            var S = right+left // 회전된 문자열
            
            // 회전된 문자열이 올바른 괄호 문자열인지 체크
            if(check(S)){
                answer += 1
            }
            // println("-".repeat(20))
            
        }
        return answer
    }
    
    fun check(S:String): Boolean {
        var stack = Stack<Char>()
        
        
        // 괄호 문자열 처리 연산
        for(letter in S){
            if(letter == '(' || letter == '{' || letter == '['){ // 괄호의 왼쪽이면 그냥 넣어줌
                stack.push(letter)
            }
            else{ // 괄호의 오른쪽
                if(stack.isNotEmpty()){ // stack 이 비었는지 확인
                    var top = stack.peek()
                    if(letter == ')' && top == '('){ // 짝이 맞나 확인 -> 아니면 바로 false 를 return
                        stack.pop()
                    }
                    else if(letter == '}' && top == '{'){
                        stack.pop()
                    }
                    else if(letter == ']' && top == '['){
                        stack.pop()
                    }
                    else{ // 짝이 다르면 false
                        // println("${letter} ${top}")
                        // println(1)
                        return false
                    }
                }
                else{ // 오른쪽 괄호가 먼저 와도 false
                    // println(2)
                    return false
                }
            }
        }
        
        if(stack.isEmpty()){ // 다 끝나고 나서 남은 괄호가 없는지 확인
            return true
        }
        else{
            // println(3)
            return false
        }
    }
}