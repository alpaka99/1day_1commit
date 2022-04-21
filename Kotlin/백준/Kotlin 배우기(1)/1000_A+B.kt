import java.io.*
import java.util.StringTokenizer

fun main() {
  val br = File("1000_A+B.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  val (num1, num2) = br.readLine().split(" ").map{it.toInt()}

  println(num1 + num2)

  for (i in 0..10){
    println(i)
  }
}

