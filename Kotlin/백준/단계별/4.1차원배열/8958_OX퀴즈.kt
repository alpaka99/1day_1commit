// 8958_OX퀴즈

import java.io.*

fun main() {
  val br = File("8958_OX퀴즈.txt").bufferedReader()

  val T = br.readLine().toInt()

  for(tc in 1..T){
    val o_list = br.readLine().split("X")
    
    var answer = 0

    var cnt = 0
    for(elem in o_list){
      cnt = elem.length

      while(cnt>0){
        answer += cnt
        cnt--
      }
    }
    println(answer)
  }
}