import java.io.*

fun main() {
  // val br = File("2439_별찍기2.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val num = br.readLine().toInt()

  for(i in 1..num){
    print(" ".repeat(num-i))
    println("*".repeat(i))
  }
}