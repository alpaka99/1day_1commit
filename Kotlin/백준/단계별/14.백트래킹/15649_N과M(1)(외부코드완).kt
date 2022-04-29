// 15649_N과M(1)


// Combination 문제인듯?

import java.io.*

var strNumList = ArrayList<String>()

fun main() {
  val br = File("15649_N과M(1).txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  val (N, M) = br.readLine().split(" ").map{it.toInt()}


  // N 이 8까지니까 string 으로 변환해놓그 그떄그때 string에 더해버리자
  var numList = (1..N).toList().map{it.toString()}

  val visited = Array<Boolean>(numList.size){false}

  var strNum: String = ""

  findPermutaion(numList, M, visited, strNum)
  
  val sortedNumList = strNumList.sorted()

  for(num in sortedNumList) {
    for(letter in num) {
      print("${letter} ")
    }
    println()
  }
}

fun findPermutaion(numList:List<String>, M:Int, visited:Array<Boolean>, strNum:String):Unit {

  var newStrNum = strNum

  // 숫자를 할당량만큼 채웠으면 탈출
  if(strNum.length == M){
    strNumList.add(strNum)
    return
  }

  // 방문표시가 없으면 방문했다 처리하고 그 아래 재귀로 넘겨주기
  for(i in 0 until visited.size) {
    if(visited[i] == false) {

      // 진입 전처리
      newStrNum += numList[i]
      visited[i] = true
      // 진입
      findPermutaion(numList, M, visited, newStrNum)


      // 진입 후처리
      newStrNum = newStrNum.dropLast(1)
      visited[i] = false
    }
  }

}


