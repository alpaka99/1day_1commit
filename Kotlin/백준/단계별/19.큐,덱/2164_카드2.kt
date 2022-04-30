// 2164_카드2

import java.io.*
import java.util.*

fun main() {

  // val br = File("2164_카드2.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  var dq = ArrayDeque<Int>()

  for(i in 1..N){
    dq.offerLast(i)
  }

  while(dq.size > 1){
    dq.pollFirst()
    dq.offerLast(dq.pollFirst())
  }

  println(dq.poll())
}
