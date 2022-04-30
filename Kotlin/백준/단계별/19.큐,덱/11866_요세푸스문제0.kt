// 11866_요세푸스문제0

import java.io.*
import java.util.*


fun main() {
  val br = File("11866_요세푸스문제0.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))


  val (N, K) = br.readLine().split(" ").map{it.toInt()}

  var table = ArrayDeque<Int>()
  var outNum = ArrayList<Int>()

  for(i in 1..N){
    table.offerLast(i)
  }

  while(table.isNotEmpty()) {
    repeat(K-1){
      table.offerLast(table.pollFirst())
    }
    outNum.add(table.pollFirst())  
  }

  println("<${outNum.joinToString()}>")
}