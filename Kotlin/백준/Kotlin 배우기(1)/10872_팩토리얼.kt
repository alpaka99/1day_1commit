// 10872_팩토리얼

import java.io.*

fun main(){
  // val br = File("10872_팩토리얼.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val num = br.readLine().toInt()

  var result = 1
  for(i in 1..num){
    result *= i
  }

  println(result)
}