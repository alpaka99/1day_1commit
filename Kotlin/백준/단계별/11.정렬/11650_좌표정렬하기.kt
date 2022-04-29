// 11650_좌표정렬하기
import java.io.*


fun main() {
  // val br = File("11650_좌표정렬하기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val numMap = mutableMapOf<Int, ArrayList<Int>>()

  for(i in 0 until N) {
    val (xi, yi) = br.readLine().split(" ").map{it.toInt()}

    var arrList = numMap.getOrDefault(xi, ArrayList<Int>())

    arrList.add(yi)
    numMap.put(xi, arrList)
  }

  
  var keys = numMap.keys.toIntArray()

  keys.sort()

  for(key in keys){
    val arrList = numMap.getOrDefault(key, ArrayList<Int>())

    var sortedArrList = arrList.sorted().toCollection(ArrayList<Int>())

    numMap.put(key, sortedArrList)
  }

  for(key in keys) {
    val answerList = numMap.getOrDefault(key, ArrayList<Int>())

    for(value in answerList){
      println("${key} ${value}")
    }
  }
}