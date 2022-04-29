// 2981_검문.kt

// N 개의 숫자를 M 으로 나누었을떄 나머지가 모두 같게되는 M 을 찾자
// 나머지가 0이어도 되고 2여도 되고 3이어도 되고 등등..
// for 문으로 2부터 어떤 숫자까지 해서 주어진 숫자를 다 나눠서 나머지를 list에 저장하고
// max 랑 min 이 같으면 해당 숫자를 인정해주는 방법?

import java.io.*

fun main() {
  // val br = File("2981_검문.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val numList = ArrayList<Int>()

  var answerList = ArrayList<Int>()

  for(n in 0 until N){
    numList.add(br.readLine().toInt())
  }

  var maxGivenNum = numList.maxOrNull() ?: 1

  var temp = ArrayList<Int>()
  for(i in 2 until maxGivenNum) {
    temp = ArrayList<Int>()

    numList.forEach{temp.add(it % i)}

    var tempMax = temp.maxOrNull()
    var tempMin = temp.minOrNull()

    if (tempMax == tempMin) {
      answerList.add(i)
    }
  }

  var sortedAnswerList = answerList.sorted()

  sortedAnswerList.forEach{print("${it} ")}
  
}

fun findYaksoo(n:Int): ArrayList<Int> {
  var temp = ArrayList<Int>()
  for (i in 2 until n){
    if(n % i == 0) {
      temp.add(i)
    }
  }
  return temp
}