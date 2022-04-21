import java.io.*

// 최대 100자리 숫자 연산
fun main(){
  // val br = File("2935_소음.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val A = br.readLine().toBigInteger()
  val op = br.readLine()
  val B = br.readLine().toBigInteger()

  if (op == "+"){
    println(A+B)
  }
  else{
    println(A*B)
  }
}