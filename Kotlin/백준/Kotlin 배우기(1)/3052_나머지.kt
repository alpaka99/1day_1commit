import java.io.*

fun main(){
  // val br = File("3052_나머지.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  var set = mutableSetOf<Int>()

  for(i in 1..10){
    set.add((br.readLine().toInt())%42)
  }

  println(set.size)
}