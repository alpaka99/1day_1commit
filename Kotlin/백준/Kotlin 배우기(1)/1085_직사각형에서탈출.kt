// 1085_직사각형에서탈출.kt

import java.io.*
import kotlin.math.*

fun main(){
  // val br = File("1085_직사각형에서탈출.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (x,y,w,h) = br.readLine().split(" ").map{it.toInt()}

  val distance = listOf(abs(w-x), abs(0-x), abs(h-y), abs(0-y))

  println(distance.minOrNull())
}