import java.io.*

fun main() {
  // val br = File("10818_최소최대.txt").bufferedReader()
  var br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()
  val nums = br.readLine().split(" ").map{it.toInt()}

  println("${nums.minOrNull()} ${nums.maxOrNull()}")

}
