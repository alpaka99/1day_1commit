import java.io.*

// 3개의 자연수 A, B, C 가 주어질 때 A x B x C 를 계산한 결과에 0부터 9까지의 숫자가 몇번 쓰였는지
fun main(){
  // val br = File("2577_숫자의개수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val A = br.readLine().toInt()
  val B = br.readLine().toInt()
  val C = br.readLine().toInt()

  var num = (A*B*C)

  var cnt_list = (0..9).map{_ -> 0}.toMutableList()

  
  while(num>9){
    cnt_list[num%10] += 1
    num /= 10
  }
  cnt_list[num] += 1

  
  cnt_list.forEach{it ->
  println(it)
  }
}