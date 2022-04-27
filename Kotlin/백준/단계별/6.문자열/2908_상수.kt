// 2908_상수

// 두 수를 입력 받고, 거꾸로 읽은 후, 대소비교해서 출력
import java.io.*
import kotlin.math.*

fun main() {
  // val br = File("2908_상수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  var (A, B) = br.readLine().split(" ")

  A = A.reversed()
  B = B.reversed()

  println("${max(A.toInt(), B.toInt())}")
}