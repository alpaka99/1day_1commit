// 1712_손익분기점

import java.io.*

// 매년 고정비용 A, 한대 생산하는데 비용 B
fun main() {
  // val br = File("1712_손익분기점.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val(A, B, C) = br.readLine().split(" ").map{it.toInt()}

  if (B >= C){
    println(-1)
    return
  }

  var cnt = 0
  while(((C-B)*cnt) - A <= 0){
    cnt += 1
  }

  println(cnt)
}