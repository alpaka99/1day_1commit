import java.io.*

fun main() {
  
  // val br = File("9498_시험성적.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val score = br.readLine().toInt()

  val ans = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "F"
  }

  println(ans)
}