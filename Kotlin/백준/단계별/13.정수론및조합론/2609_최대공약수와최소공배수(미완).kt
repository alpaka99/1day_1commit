// 2609_최대공약수와최소공배수.kt

// 두개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램
// 약수를 모두 구해서 반환하는 함수를 만들고
// set.plus()에 넣어서 다 곱해서 최소공배수 만들고
// interset(a, b)를 통해서 나온거를 보고 최대공약수 만들면 될듯?
import java.io.*
import kotlin.math.*

fun main() {
  // val br = File("2609_최대공약수와최소공배수.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (A, B) = br.readLine().split(" ").map{it.toInt()}

  val yaksooA = getYaksoo(A)
  val yaksooB = getYaksoo(B)

  var set = mutableSetOf<Int>()

  yaksooA.keys.forEach{set.add(it)}
  yaksooB.keys.forEach{set.add(it)}

  // println(set)
  var maxGongyaksoo = 1
  var minGongbaesoo = 1
  
  set.forEach{maxGongyaksoo = maxGongyaksoo * it}


  set.forEach{
    var a = yaksooA.getOrDefault(it, 1)
    var b = yaksooB.getOrDefault(it, 1)

    // println("${it}, ${max(a, b)}")
    minGongbaesoo *= it.toDouble().pow(max(a, b)).toInt()
  }

  println(maxGongyaksoo)
  println(minGongbaesoo)

}

// 에라토스테네스의 체를 만들어보자
fun getYaksoo(n:Int): MutableMap<Int, Int> {
  var temp = mutableMapOf<Int, Int>()
  
  // 약수가 소수인지 아닌지를 판단하는 arr 0..n-1
  var visited = Array<Boolean>(n){false}

  var second = 0
  var tempN = n
  // 약수이면서 소수인 수들을 찾아서 temp에 넣자
  for(i in 2 until n) {
    if(visited[i] == false) { // 소수이면서
      if(n % i == 0) { // 약수인 숫자
        // 약수와 약수가 몇번 들어가는지를 넣자
        second = 0
        tempN = n
        while(tempN % i == 0) {
          tempN /= i
          second += 1
        }
        temp[i] = second


        // 체 거르는 작업 시작
        var cnt = i + i
        while(cnt < n ){
          visited[cnt] = true
          cnt += i
        }
      }
    }
  }
  // println(temp)
  return temp
}