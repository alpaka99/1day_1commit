// 1427_소트인사이드

import java.io.*

fun main() {
  // val br = File("1427_소트인사이드.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val numArr = br.readLine().toCharArray().map{it.toString().toInt()}

  val sortedArr = numArr.sortedDescending()
  
  var answer = ""

  for (num in sortedArr) {
    answer += num.toString()
  }

  println(answer)

}