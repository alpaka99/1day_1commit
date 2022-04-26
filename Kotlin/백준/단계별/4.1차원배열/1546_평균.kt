// 1546_평균 by forEach

import java.io.*

fun main(){
  val br = File("1546_평균.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine()!!.toInt()
  val scores = br.readLine()!!.split(" ").map{it.toDouble()}.toMutableList()

  val max_num = scores.maxOrNull()

  // for(i in 0 until scores.size){
  //   scores[i] = (scores[i]/max_num!!)*100
  // }
  scores.forEach{it->(it/max_num!!)*100}
  println(scores.average())
}

// // 1546_평균 by for

// import java.io.*

// fun main(){
//   // val br = File("1546_평균.txt").bufferedReader()
//   val br = BufferedReader(InputStreamReader(System.`in`))

//   val N = br.readLine()!!.toInt()
//   val scores = br.readLine()!!.split(" ").map{it.toDouble()}.toMutableList()

//   val max_num = scores.maxOrNull()

//   for(i in 0 until scores.size){
//     scores[i] = (scores[i]/max_num!!)*100
//   }
//   println(scores.average())
// }