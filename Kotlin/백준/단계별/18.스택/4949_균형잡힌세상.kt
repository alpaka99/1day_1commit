// 4949_균형잡힌세상


import java.io.*
import java.util.*


// 작은 괄호 안에서 중간 괄호를 만나면 재귀적으로 파고 내려가는 함수를 짜야겠다
// -> charArray 를 어디까지 잘라야할지 감이 안잡혀서 flag 를 이용해서 짜는걸로 변경
fun main() {
  // val br = File("4949_균형잡힌세상.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  base@ while(true) {
    val dat = br.readLine().toCharArray()


    // 입력 종료 조건
    if(dat[0] == '.'){
      break@base
    }

    if(check(dat)) {
      println("yes")
    } else {
      println("no")
    }
    
  }
}

fun check(dat:CharArray):Boolean {
    var stack = Stack<Char>()


    for(letter in dat) {
      if(letter == '(' || letter == '['){
        stack.push(letter)
      }

      if(letter == ')'){
        if(stack.isNotEmpty()){
          if(stack.peek() == '('){
            stack.pop()
          }
          else {
            return false
          }
        }
        else {
          return false
        }
      }

      if (letter == ']'){
        if(stack.isNotEmpty()){
          if(stack.peek() == '['){
            stack.pop()
          }
          else {
            return false
          }
        }
        else {
          return false
        }
      }
    }


    if(stack.isEmpty()) {
      return true
    } 
    else {
      return false
    }
}
 

