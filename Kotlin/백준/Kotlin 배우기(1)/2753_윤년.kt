import java.io.*

fun main() {
  // val br = File("2753_윤년.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val year = br.readLine().toInt()

  println(yoonnyeon(year))
}

fun yoonnyeon(year:Int) : Int{
  if (year%4 == 0){
    if (year % 100 != 0 || year % 400 == 0) {
      return 1
    }
  }
  return 0
}