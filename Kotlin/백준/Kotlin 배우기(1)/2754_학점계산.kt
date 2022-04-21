import java.io.*

fun main() {
  // val br = File("2754_학점계산.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val grade = br.readLine()

  println(
    when(grade[0]) {
      'A' -> 4.0f + pzm(grade[1])
      'B' -> 3.0f + pzm(grade[1])
      'C' -> 2.0f + pzm(grade[1])
      'D' -> 1.0f + pzm(grade[1])
      else -> 0.0f
    }
  )
}


fun pzm(grade:Char):Float = when(grade){
  '+' -> 0.3f
  '-' -> -0.3f
  else -> 0.0f
}
