// 1157_단어공부

// 가장 많이 사용된 알파벳 출력
// 대소문자 구분 x

import java.io.*

fun main(){
  // val br = File("1157_단어공부.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val str = br.readLine().toLowerCase()
  
  var alphabet = mutableMapOf<Char, Int>()
  for(i in 'a'..'z'){
    alphabet[i] = 0
  }

  str.forEach{it->
    alphabet.put(it, alphabet.getOrDefault(it,0)+1)
  }

  var keys = alphabet.keys
  var values = alphabet.values
  var max_num = alphabet.values.maxOrNull()
  

  if(values.count{it==max_num} >= 2){
    println("?")
  } else {
    for(key in keys){
      if(alphabet.getOrDefault(key,0) == max_num){
        println(key.toUpperCase())
      }
    }
  }
}