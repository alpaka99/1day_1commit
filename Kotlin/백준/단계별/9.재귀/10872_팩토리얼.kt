// 10872_팩토리얼

import java.io.*

fun main() {
  // val br = File("10872_팩토리얼.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  println(factorial(N))
}

fun factorial(n:Int): Int {
  if(n <= 1){
    return 1
  }

  return factorial(n-1)*n
}