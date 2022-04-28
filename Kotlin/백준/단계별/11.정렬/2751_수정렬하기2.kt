// 2751_수정렬하기2
import java.io.*

fun main() {
  // val br = File("2751_수정렬하기2.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))
  val N = br.readLine().toInt()

  val arr1 = Array(N){it->br.readLine().toInt()}

  val arr2 = arr1.sorted()

  arr2.forEach{bw.write("${it}\n")}
  bw.flush()
  bw.close()
}