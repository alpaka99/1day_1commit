import java.io.*

fun main() {

  // val br = File("1001_A-B.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (a, b) = br.readLine().split(" ").map{it.toInt()}

  println(a-b)
}