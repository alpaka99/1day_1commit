// 11931_수정렬하기4

import java.io.*

fun main(){
  // val br = File("11931_수정렬하기4.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val N = br.readLine().toInt()

  val arr = IntArray(1000001){0}
  
  for(i in 0 until N){
    arr[br.readLine().toInt()]++
  }

  arr.reverse()

  for(i in 1000000 downTo 0){
    bw.write("${i+1}\n".repeat(arr[i]))
  }
  bw.close()

}


//   fun main() {
//     // val br = File("11931_수정렬하기4.txt").bufferedReader()
//     val br = System.`in`.bufferedReader()
//     val bw = System.`out`.bufferedWriter()
//     val N: Int = br.readLine().toInt()

//     val array = IntArray(N+1)
//     for (i in 0 until N) {
//       array[br.readLine().toInt()]++
//     }
//     br.close()

//     for (i in N downTo 0) {
//       bw.write("$i\n".repeat(array[i]))
//     }
//     bw.close()
// }