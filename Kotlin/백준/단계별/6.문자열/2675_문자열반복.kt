// 2675_문자열반복.kt

import java.io.*

fun main(){
  val br = BufferedReader(InputStreamReader(System.`in`))
  // val br = File("2675_문자열반복.txt").bufferedReader()

  val T = br.readLine().toInt()

  for(tc in 0 until T){
    var(R, S) = br.readLine().split(" ")
    var iterate_nums = R.toInt()

    S.forEach{it->
    print("${it}".repeat(iterate_nums))
    }
    println()
  }
}