// 11651_좌표정렬하기2

import java.io.*

fun main() {
  val br = File("11651_좌표정렬하기2.txt").bufferedReader()

  val N = br.readLine().toInt()

  var numList = ArrayList<Pair<Int, Int>>()

  for(i in 0 until N) {
    val (xi, yi) = br.readLine().split(" ").map{it.toInt()}

    numList.add(Pair(yi, xi))
  }

  numList.sortBy{it.first}

  val numGroup = numList.groupBy{it.first}
  
}