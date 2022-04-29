// 5086_배수와약수

/*
1. A가 B 의 약수이다
2. A가 B 의 배수이다
3. A가 B의 약수 혹은 배수가 아니다

-> 약수인지 구하는 함수, 배수인지 구하는 함수를 만들면 될듯?
 */

import java.io.*

 fun main() {
  //  val br = File("5086_배수와약수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))


  base@ while(true) {
    var (A, B) = br.readLine().split(" ").map{it.toInt()}
    if(A == 0 && B == 0){
      break@base
    }

    if(baeSoo(A, B)) {
        println("factor")
        continue
      } else if(yakSoo(A, B)) {
      println("multiple")
      continue
    } else {
      println("neither")
    }

  }



 }

 fun yakSoo(A:Int, B:Int):Boolean {
   if(A < B) {
     return false
   }

   if (A % B == 0) {
     return true
   }
   return false
 }

 fun baeSoo(A:Int, B:Int):Boolean {
   if(A > B) {
     return false
   }
   if (B % A == 0) {
     return true
   }
   return false
 }