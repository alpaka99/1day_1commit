// 5622_다이얼

// 오래된 다이얼 전호기
// 1을 제외한 각 숫자마다 저장된 알파벳 존재
// 문자열이 주어졌을때 전화를 걸기 위해 걸리는 최소 시간
// 숫자 하나를 누르면 다이얼이 처음 위치로 돌아감
// 숫자 1을 거는데는 1초가 걸리고 1칸 옆으로 이동할떄 마다 1초

import java.io.*

fun main(){

  // val br = File("5622_다이얼.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))


  val str = br.readLine()

  var total = str.length

  str.forEach{it->
    when(it){
      in 'A'..'C'-> total += 2
      in 'D'..'F'-> total += 3
      in 'G'..'I'-> total += 4
      in 'J'..'L'-> total += 5
      in 'M'..'O'-> total += 6
      in 'P'..'S'-> total += 7
      in 'T'..'V'-> total += 8
      in 'W'..'Z'-> total += 9
      else -> total += 0
    }
  }

  println(total)
}