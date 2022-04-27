// 1002_터렛

import java.io.*
import kotlin.math.*


fun main() {
  // val br = File("1002_터렛.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val T = br.readLine().toInt()

  for (tc in 0 until T){

    val nums = br.readLine().split(" ").map{it.toDouble()}
    val x1 = nums[0]
    val y1 = nums[1]
    val r1 = nums[2]
    val x2 = nums[3]
    val y2 = nums[4]
    val r2 = nums[5]

    if (x1==x2 && y1==y2 && r1==r2) {
      println(-1)
      continue
    }

    val distance = sqrt((x1-x2).pow(2) + (y1-y2).pow(2)).toInt()
    val r_distance = (r1 + r2).toInt()

    when(distance){
      0 ->println(0)
      in 0 until r_distance -> println(2)
      r_distance -> println(1)
    }
  }
}