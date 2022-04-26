// 11654_아스키코드.kt

import java.io.*

fun main(){
  // val br = File("11654_아스키코드.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val str = br.readLine()

  print(str[0].code)
}