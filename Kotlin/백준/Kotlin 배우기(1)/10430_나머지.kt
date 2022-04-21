import java.io.*

fun main() {
  // val br = File("10430_나머지.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (A, B, C) = br.readLine().split(" ").map{it.toInt()}

  println("${(A+B)%C}\n${((A%C) + (B%C))%C}\n${(A*B)%C}\n${ ((A%C) * (B%C))%C}")
}