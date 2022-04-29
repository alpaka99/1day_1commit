// 9663_N-Queen


// 크기가 N x N 인 체스판 위에 퀸 N 개를 서로 공격할 수 없게 놓는 문제
// 퀸을 놓는 방법의 수를 구하라
import java.io.*

var cnt = 0
var matrix = ArrayList<ArrayList<Int>>()

// delta N, NE, E, SE, S, SW, W, NW
val dr = listOf<Int>(-1, -1, 0, 1, 1, 1, 0, -1)
val dc = listOf<Int>(0, 1, 1, 1, 0, -1, -1, -1)

fun main() {

  // val br = File("9663_N-Queen.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  
  val N = br.readLine().toInt()

  for(i in 0 until N){
    matrix.add(ArrayList<Int>())
    for(j in 0 until N) {
      matrix[i].add(0)
    }
  }
  nQueens(0)

  println(cnt)
}


fun nQueens( level:Int):Unit{
  if(level == matrix.size){
    cnt += 1
    return
  }

  for( col in 0 until matrix.size){
    if (check(level, col)){ // 여기가 백트랙킹 단계 아닐까?
      matrix[level][col] = 1 // 진입전
      nQueens(level+1) // 진입
      matrix[level][col] = 0 // 진입후처리
    }
  }
}

// 해당 자리에 queen 을 놓을 수 있나 없나 체크하는 함수
fun check(r:Int, c:Int):Boolean {

  

  

  for(i in 0 until 8) {
    var step = 1

    var nr = r + dr[i]*step
    var nc = c + dc[i]*step

    while((nr in 0 until matrix.size && nc in 0 until matrix.size)) {
      if(matrix[nr][nc] == 1){
        return false
      }
      step += 1

      nr = r + dr[i]*step
      nc = c + dc[i]*step
    }
  }
  return true
}