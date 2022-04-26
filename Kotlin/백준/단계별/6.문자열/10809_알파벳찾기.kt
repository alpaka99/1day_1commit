// 10809_알파벳찾기.kt

// import java.io.*

// var alphabet: Array<Int> = arrayOf()

// fun main(){
//   // val br = File("10809_알파벳찾기.txt").bufferedReader()
//   val br = BufferedReader(InputStreamReader(System.`in`))

//   alphabet = Array(26){-1}

//   val S = br.readLine()
//   val std = 'a'.toInt()

//   for(i in S.length-1 downTo 0){
//     var idx = S[i].toInt() - std
//     alphabet[idx] = i
//   }

//   alphabet.forEach{it->
//     print("${it} ")
//   }
// }  

import java.io.*

var alphabet: Array<Int> = arrayOf()

fun main(){
  val br = File("10809_알파벳찾기.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  alphabet = Array(26){-1}

  val S = br.readLine()
  val std = 'a'.toInt()

  for(i in 'a'..'z'){
    println(S.find{it==i})
  }
}  