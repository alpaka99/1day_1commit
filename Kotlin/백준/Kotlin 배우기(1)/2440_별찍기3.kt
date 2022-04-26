import java.io.*

fun main() {
  // val br = File("2440_별찍기3.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val num = br.readLine().toInt()

  for(i in num downTo 1){
    println("*".repeat(i))
  }
}