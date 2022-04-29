// 1931_회의실배정

// 이게 왜 안됨?? 

import java.io.*

var timeTable = ArrayList<Pair<Int, Int>>()
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  // val br = File("1931_회의실배정.txt").bufferedReader()

  val N = br.readLine().toInt()

  var timeSet = mutableSetOf<Pair<Int,Int>>()

  repeat(N) {
    var (start, end) = br.readLine().split(" ").map{it.toInt()}

    timeSet.add(Pair(start, end))
  }

  var timeTable = timeSet.toCollection(ArrayList<Pair<Int,Int>>())


  timeTable.sortBy{it.second}

  var cnt = 0

  var end = 0


  for(i in 0 until timeTable.size) {
    if(timeTable[i].first >= end){
      // println(timeTable[i])
      end = timeTable[i].second
      cnt += 1
    }
  }

  println(cnt)
}


// 이건 왜 됨?? ㅁㅊ
// data class Meeting(val start: Int, val end: Int)

// fun main() {
//     val br = System.`in`.bufferedReader()
//     val bw = System.out.bufferedWriter()
//     val n = br.readLine().toInt()
//     val meetings = mutableListOf<Meeting>()
//     repeat(n) {
//         val (s, e) = br.readLine().toString().split(" ").map { it.toInt() }
//         meetings.add(Meeting(s, e))
//     }
//     meetings.sortWith(compareBy({ it.end }, { it.start }))
//     var count = 1
//     var e = meetings[0].end
//     for (i in 1 until n) {
//         if (meetings[i].start >= e) {
//             e = meetings[i].end
//             count++
//         }
//     }
//     bw.write("$count")
//     br.close()
//     bw.close()
// }