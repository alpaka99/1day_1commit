import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (a, b) = br.readLine().split(" ").map{it.toInt()}

  println(a*b)
}