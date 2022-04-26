// 영어 대소문자와 공백으로 이루어진 문자열
// 이 문자열에는 몇개의 단어가 있을까?
// 대신 한 단어가 여러번 등장해도 등한한 횟수만큼 모두 센다

// 그냥 split 으로 하면 될듯?
// 공백+단어는 공백을 기준으로 나눠도 공백, 단어 이렇게 됨으로,
// .filter{it.isNotEmpty()} 를 이용해서 공백을 싹 다 없애자
import java.io.*

fun main(){
  // val br = File("1152_단어의갯수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val input = br.readLine().split(" ").filter{it.isNotEmpty()}
  println(input.size)


}