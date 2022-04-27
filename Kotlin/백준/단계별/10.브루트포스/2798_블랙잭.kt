// 2798_블랙잭

// 카드 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임
// N 장의 카드를 모두 보이게 놓고, 숫자 M 을 외침
// N 장의 카드 안에서 3장 선택
// M 을 넘지 않으면서 M에 최대한 가까운 3장의 합은?

// -> combinations 하면 될듯?

import java.io.*
import kotlin.math.*

fun main() {

  // val br = File("2798_블랙잭.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (N, M) = br.readLine().split(" ").map{it.toInt()}

  val cards = br.readLine().split(" ").filter{it.isNotEmpty()}.map{it.toInt()}.sorted()

  val combs = combination(cards, 3)
  
  var answer = 0
  
  combs.forEach{
    if(it.sum() <=M) {
      answer = max(answer, it.sum())
    }
  }
  
  println(answer)


}

fun<T> combination(el: List<T>, limit: Int = el.size, fin: List<T> = listOf(), index: Int = 0): List<List<T>>{
  return if(fin.size>=limit){
    listOf(fin)
  } else {
    el.slice(index until el.size).flatMapIndexed {i:Int, t:T -> combination(el, limit, fin+t, index+i+1)}
  }
}