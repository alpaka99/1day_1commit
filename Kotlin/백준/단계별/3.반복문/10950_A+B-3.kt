// 10950_A+B-3

import java.io.*

fun main() {
  // val br = File("10950_A+B-3.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  
  val T = br.readLine().toInt()

  for(tc in 1..T){
    val(A, B) = br.readLine().split(" ").map{it.toInt()}

    println("${A+B}")
  }
}