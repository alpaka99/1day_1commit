import java.io.*

fun main() {
  // val br = File("2884_알람시계.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  // H 는 시간, M 은 분, 24시간 표현 사용
  // 지금 시간에서 45분 떙기기
  var (H, M) = br.readLine().split(" ").map{it.toInt()}

  M -= 45
  if (M < 0){
    M += 60
    H -= 1
    if (H < 0){
      H += 24
    }
  }

  println("${H} ${M}")
}