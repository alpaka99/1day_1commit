// 1065_한수

// 어떤 양의 정수 x 의 각 자리수가 등차수열을 이루면 -> 한수
import java.io.*

var arr: MutableList<Int> = mutableListOf()

fun main(){
  // val br = File("1065_한수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  var cnt = 0
  
  for(i in 1..N){
    when(i){
      in 1..99 -> cnt++
      else ->if(check(i) == true){
        cnt++
      } else{
        // println(i)
      }
    }
  }

  println(cnt)
}

fun check(n:Int):Boolean{
  var str = n.toString()
  var diff = str[0].toInt() - str[1].toInt()

  for(i in 0 until str.length-1){
    if((str[i].toInt()-str[i+1].toInt()) != diff){
      return false
    }
  }
  return true
}