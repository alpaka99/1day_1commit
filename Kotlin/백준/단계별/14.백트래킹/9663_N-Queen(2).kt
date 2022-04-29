// 9663_N-Queen(2).kt


import java.io.*
import kotlin.math.*

var n = 0
var cnt = 0
var col = Array(15){0}


fun main() {
  // val br = File("9663_N-Queen.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  n = br.readLine().toInt()

  dfs(0)
  println(cnt)
}

fun dfs(x: Int) {
  if(x == n){
    cnt+= 1
    return
  } else {
    for(i in 0 until n) {
      col[x] = i
      if(check(x)){
        dfs(x+1)
      }
    }
  }
}


fun check(level:Int) : Boolean {
  for(i in 0 until level) {
    if(col[i] == col[level] || abs(col[level] - col[i]) == abs(level - i)){
      return false
    }
  }
  return true
}