import java.io.*

fun main() {
  // val br = File("2379_구구단.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val dan: Int = br.readLine().toInt()

  for(i in 1..9){
    println("${dan} * ${i} = ${dan*i}")
  }
}