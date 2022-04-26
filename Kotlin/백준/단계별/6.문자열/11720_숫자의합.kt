// 11720_숫자의합.kt

import java.io.*

fun main(){
  // val br = File("11720_숫자의합.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val num_str = br.readLine()

  var total = 0
  var std = '0'.toInt()
  num_str.forEach{it->
    total += (it.toInt() - std)
  }

  println(total)
}