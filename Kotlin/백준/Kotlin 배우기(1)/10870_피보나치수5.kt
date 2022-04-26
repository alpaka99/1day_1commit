// 10870_피보나치수5

import java.io.*

fun main() {
  // val br = File("10870_피보나치수5.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val num = br.readLine().toInt()

  var left = 0
  var right = 1
  var tmp = 0

  var cnt = 1
  while (cnt < num){
    tmp = left + right
    left = right
    right = tmp
    cnt += 1
  }

  if(num==0){
    println(0)
  }
  else if(num==1){
    println(1)
  }
  else{
    println(right)
  }

}