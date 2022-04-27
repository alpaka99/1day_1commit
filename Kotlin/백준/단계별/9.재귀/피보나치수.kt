// 피보나치수

import java.io.*

fun main() {
  val br = File("10872_팩토리얼.txt").bufferedReader()

  val N = br.readLine().toInt()

  if(N == 0 || N == 1){
    println(1)
  }

  println(factorial(N))
}

fun factorial(n:Int):Int{
  if (n==1){
    return 1
  }
  if (n<=0){
    return 0
  }

  return factorial(n-1) + factorial(n-2)
}