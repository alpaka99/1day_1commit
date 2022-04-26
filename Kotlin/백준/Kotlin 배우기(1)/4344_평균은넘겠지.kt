import java.io.*
import kotlin.math.*

fun main(){
  // val br = File("4344_평균은넘겠지.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val tc = br.readLine().toInt()

  for (testcase in 1..tc){
    val datas = br.readLine().split(" ").map{it.toInt()}
    var nums = datas.slice(1 until datas.size)

    val size = nums.size
    val avg = nums.average()

    var cnt:Double = 0.0
    nums.forEach{ it->
      if(it > avg){
        cnt += 1
      }
    }
    val result = String.format("%.3f", (cnt/size)*100)
    println("${result}%")
  }
}


