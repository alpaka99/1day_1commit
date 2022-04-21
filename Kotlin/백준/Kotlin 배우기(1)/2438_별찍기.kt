import java.io.*

fun main() {
  // val br = File("2438_별찍기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val num = br.readLine().toInt()

  for(i in 1..num){
    println("*".repeat(i))
  }
}