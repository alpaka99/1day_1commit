// 1181_단어정렬

import java.io.*

fun main() {
  // val br = File("1181_단어정렬.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val wordMap = mutableMapOf<Int, ArrayList<String>>()

 for (n in 0 until N) {
   val word = br.readLine()

  val length = word.length

  var newArr = wordMap.getOrDefault(length, ArrayList<String>())

  newArr.add(word)

  wordMap.put(length, newArr)
 }

  val sortedKeys = wordMap.keys.sorted()

  for (key in sortedKeys) {
    val newSet = wordMap.getOrDefault(key, ArrayList<String>()).toSet()

    val finalList = newSet.toList().sorted().toCollection(ArrayList<String>())

    wordMap.put(key, finalList)
  }

  for(key in sortedKeys) {
    for (value in wordMap.getOrDefault(key, ArrayList<String>())) {
      println("${value}")
    }
  }
}