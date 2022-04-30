// 7576_토마토

import java.io.*
import java.util.*

var box = ArrayList<ArrayList<Int>>()
val dr = arrayOf(-1, 0, 1, 0)
val dc = arrayOf(0, 1, 0, -1)


fun main() {
  // val br = File("7576_토마토.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  var (M, N) = br.readLine().split(" ").map{it.toInt()}

  repeat(N){
    var temp = br.readLine().split(" ").map{it.toInt()}.toCollection(ArrayList<Int>())

    box.add(temp)
  }

  var yesterday = countUnriped(N)
  var today = 0
  var days = 0

  if(yesterday == 0){
    println(0)
  }

  while(yesterday != today) {
    yesterday = today
    days++
    ripe(N, M)
    today = countUnriped(N)
  }

  if(today == 0){
    println(days-1) // -1 해주는 이유 : 다 익었는지 아닌지 비교를 위해서 한번 더 돌리기 떄문이다.
  }
  else {
    println(-1)
  }

}

fun ripe(N:Int, M:Int):Unit { // 토마토를 익게 하는 함수
  var deque = ArrayDeque<Pair<Int, Int>>()

  for(i in 0 until N){
    for (j in 0 until M) {
      if(box[i][j] == 1) { // 익은 토마토를 찾으면
        deque.offerLast(Pair(i, j))
      }
    }
  }
  while(deque.isNotEmpty()) {
    val (r, c) = deque.pollFirst()
      for(k in 0..3) { // 4방을 돌면서
        var nr = r + dr[k]
        var nc = c + dc[k]

        if(!(nr in 0 until N && nc in 0 until M)){ // 해당 4방이 박스 안에 있는지 확인
          continue
        }

        if(box[nr][nc] == 0) { // 안익은 토마토이면
          box[nr][nc] = 1 // 익은 토마토로 만든다
        }
      }
    }
}

fun countUnriped(N:Int):Int { // 안익은 토마토를 세는 함수
  var cnt = 0
  for(i in 0 until N) {
    cnt += box[i].count{it == 0}
  }
  return cnt
}