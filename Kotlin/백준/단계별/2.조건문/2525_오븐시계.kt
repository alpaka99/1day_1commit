// 2525_오븐시계
import java.io. *

fun main(){
  // val br = File("2525_오븐시계.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (A, B) = br.readLine().split(" ").map{it.toInt()}
  val C = br.readLine().toInt()

  var min = B+C
  var hour = A + (min / 60)

  println("${hour%24} ${min%60}")

}