// 2292_벌집

import java.io.*

fun main() {
  // val br = File("2292_벌집.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  var num = br.readLine().toLong()

  // 각 level마다 등차가 6 증가하는 수열
  var cnt = 0
  
  if (num == 1.toLong()){
    println(1)
  }

  while(num > 0){
    num -= cnt*6
    cnt += 1
  }

  println(cnt)

}