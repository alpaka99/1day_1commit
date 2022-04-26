// 2750_수정렬하기.kt

import java.io.*

fun main(){
  // val br = File("2750_수정렬하기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  
  val N = br.readLine().toInt()

  var nums = mutableListOf<Int>()
  for(i in 1..N){
    nums.add(br.readLine().toInt())
  }

  nums.sort()

  nums.forEach{it->
    println(it)
  }
}