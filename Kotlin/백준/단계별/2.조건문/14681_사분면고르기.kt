import java.io.*

fun main() {
  // val br = File("14681_사분면고르기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val x = br.readLine().toInt()
  val y = br.readLine().toInt()

  var Quadrant:Int = 0

  if(x>=0){
    if (y>=0){
      Quadrant = 1
    } else {
      Quadrant = 4
    }
  }
  else{
    if(y>=0){
      Quadrant = 2
    } else{
      Quadrant = 3
    }
  }
  println(Quadrant)
}