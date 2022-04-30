// 9012_괄호

import java.io.*
import java.util.*


// 올바른 괄호면 YES 아니면 NO 출력
fun main() {
  // val br = File("9012_괄호.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val TC = br.readLine().toInt()

  for(tc in 0 until TC) {
    val dat = br.readLine().toCharArray().toTypedArray()

    if(check(dat)) {
      println("YES")
    } else {
      println("NO")
    }
    
  }
}

fun check(dat: Array<Char>):Boolean {
  var stack = Stack<Char>()

  for(letter in dat){
    if(letter == '('){
      stack.push(letter)
    } else {
      if(stack.isNotEmpty()) {
        stack.pop()
      } else {
        return false
      }
    }
  }

  if(stack.isEmpty()) {
    return true
  } else {
    return false
  }

}