// 2108_통계학

import java.io.*
import kotlin.math.*

fun main() {

  // val br = File("2108_통계학.txt").bufferedReader()
  val br =BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val numlist = arrayListOf<Int>()

  for(i in 0 until N){
    numlist.add(br.readLine().toInt())
  }

  numlist.sort()

  val answer1 = round(numlist.average()).toInt()
  println(answer1)

  val answer2 = numlist[N/2]
  println(answer2)

  val nummap = mutableMapOf<Int, Int>()

  for(num in numlist) {
    nummap.put(num, nummap.getOrDefault(num, 0)+1)
  }

  val maxValue = nummap.values.maxOrNull()

  val frequentList = arrayListOf<Int>()

  for (key in nummap.keys) {
    if (nummap[key]==maxValue) {
      frequentList.add(key)
    }
  }

  frequentList.sort()
  
  var answer3 = 0
  if(frequentList.size >= 2){
    answer3 = frequentList[1]
  }
  else{
    answer3 = frequentList[0]
  }

  println(answer3)

  val answer4 = (numlist[numlist.size-1] - numlist[0])
  println(answer4)

}