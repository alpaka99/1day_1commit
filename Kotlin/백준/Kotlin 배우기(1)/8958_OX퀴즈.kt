import java.io.*

fun main(){
  // val br = File("8958_OX퀴즈.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val testcase = br.readLine().toInt()

  for(tc in 1..testcase){
    val ox = br.readLine()

    var ans = 0
    var cnt = 0

    ox!!.forEach{ it->
      if(it=='O'){
        cnt += 1
      }
      else{        
        cnt = 0
      }
      ans += cnt
    }

    if(ans==0 && cnt!=0){
      println(cnt)
    }
    else{
      println(ans)
    }
  }
}