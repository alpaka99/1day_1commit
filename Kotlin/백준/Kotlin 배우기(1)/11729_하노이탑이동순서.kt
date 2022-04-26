// 11729_하노이탑이동순서

import java.io.*

fun hanoi(K:Int):Unit{
  
  hanoi(K+1)
}

fun main(){
  val br = File("11729_하노이탑이동순서.txt").bufferedReader()

  val N = br.readLine().toInt()

  var K = 0

}