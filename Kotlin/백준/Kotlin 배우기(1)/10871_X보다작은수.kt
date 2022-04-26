import java.io.*

// 정수 N 개로 이루어진 수열 A 와 정수 X
// A 에서 X 보다 작은 수를 모두 출력하는 프로그램
fun main() {
  // val br = File("10871_X보다작은수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (N, X) = br.readLine().split(" ").map{it.toInt()}

  val nums = br.readLine().split(" ").map{it.toInt()}

  var answer = ""

  nums.forEach{ it->
    if(it<X){
      answer += it
      answer += " "
    }
  }

  println(answer)
}