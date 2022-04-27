// 1316_그룹단어체커

// 단어안에 알파벳이 뭉쳐서 나타나면 그룹단어,
// 어떤 알파벳이 그룹 말고 다른곳에서도 발견되면 그룹단어 아님

import java.io.*

var alphabet : Array<Boolean> = arrayOf()
fun main() {
  // val br = File("1316_그룹단어체커.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  
  
  val N = br.readLine().toInt()

  var answer = 0

  for (tc in 0 until N) {

    val str = br.readLine()

    alphabet = Array(26){false}
    alphabet[str[0].toInt()-'a'.toInt()] = true

    var flag = true
    base@ for(i in 1 until str.length) {
      if (str[i-1] != str[i]) {
        if (alphabet[str[i].toInt() - 'a'.toInt()] == true){
          flag = false
          break@base
        } else {
          alphabet[str[i].toInt() - 'a'.toInt()] = true
        }
      } else{
        continue
      }
    }

    if (flag) {
      answer += 1
    }
  }
  println(answer)
}