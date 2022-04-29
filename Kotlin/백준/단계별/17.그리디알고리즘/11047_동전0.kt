// 11047_동전0.kt

import java.io.*

fun main() {
  // val br = File("11047_동전0.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  var (N, K) = br.readLine().split(" ").map{it.toInt()}

  var prices = ArrayList<Int>()

  for(n in 0 until N) {
    prices.add(br.readLine().toInt())
  }

  prices.sortDescending()

  var cnt = 0

  for(price in prices){
    cnt += (K / price)
    K %= price
  }

  println(cnt)

}