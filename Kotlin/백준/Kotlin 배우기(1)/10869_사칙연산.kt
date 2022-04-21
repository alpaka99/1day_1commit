import java.io.*

fun main() {

  val br = File("10869_사칙연산.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  var (a, b) = br.readLine().split(" ").map{it.toInt()}

  println("${a+b}\n${a-b}\n${a*b}\n${a/b}\n${a%b}")
}