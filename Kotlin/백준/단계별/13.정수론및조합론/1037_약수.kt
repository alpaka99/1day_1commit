// 1037_약수.kt

// 수를 1씩 증가하면서 list 를 돌면서 이것들을 전부 다 약수로 갖는걸 찾아야할듯?
// -> x

// 진짜 약수가 '전부' 주어졌기때문에 모든 진짜약수의 최대공배수를 구하면 안되고
// 최대값 x 최솟값을 해야한다는디? 이해가 안감

import java.io.*

fun main() {
  // val br = File("1037_약수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val yaksooList = br.readLine().split(" ").map{it.toInt()}

  var max = yaksooList.maxOrNull() ?: 1
  val min = yaksooList.minOrNull() ?: 1

  println(max*min)
}