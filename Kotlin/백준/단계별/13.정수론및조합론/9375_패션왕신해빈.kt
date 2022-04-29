// 9375_패션왕신해빈.kt

import java.io.*

fun main() {
  // val br = File("9375_패션왕신해빈.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val T = br.readLine().toInt()

  for(tc in 0 until T) {
    var N = br.readLine().toInt()

    

    var clothMap = mutableMapOf<String, ArrayList<String>>()

    for(n in 0 until N) {
      var (item, category) = br.readLine().split(" ")

      var newList = clothMap.getOrDefault(category, ArrayList<String>())
      newList.add(item)
      clothMap.put(category, newList)      
  }


  
    var keys = clothMap.keys
    var answer = 1
    // println(clothMap)
    for (key in keys) {
      answer *= (clothMap.getOrDefault(key, ArrayList<String>()).size + 1)
    }

    println(answer - 1)
  }
}