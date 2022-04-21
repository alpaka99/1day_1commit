import java.io.*


fun main() {

  val br = File("1008_A%B.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  val (a, b) = br.readLine().split(" ").map{it.toDouble()}

  val ans : Double = a/b
  println(ans)
  
}