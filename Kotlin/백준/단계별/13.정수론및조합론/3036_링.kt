// 3036_링.kt

// 어떤 링이 돌떄 나머지 링은 몇바퀴 도는지

import java.io.*
import kotlin.math.*

fun main() {
  // val br = File("3036_링.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val numList = br.readLine().split(" ").map{it.toInt()}

  val std = numList[0]
  
  for(i in 1 until numList.size) {
    var base = findMaxGongyaksoo(std, numList[i])
    println("${std/base}/${numList[i]/base}")
  }
}

fun findMaxGongyaksoo(A:Int, B:Int):Int {
  var newA = max(A, B)
  var newB = min(A, B)

  while(!(newA % newB == 0)) {
    var tmp = newA % newB
    newA = newB
    newB = tmp
  }

  return newB
}