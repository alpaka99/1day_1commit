// 2231_분해합

import java.io.*

fun main() {
  // val br = File("2231_분해합.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  
  val N = br.readLine().toInt()

  var str_i = ""
  var tmp = 0

  for(i in 1 until N){
    tmp = i
    str_i = i.toString()

    str_i.forEach{it->
      tmp += it.toString().toInt()
    }
    
    if (tmp == N){
      println(i)
      return
    }
  }
  println(0)
  return
}