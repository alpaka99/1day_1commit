import java.io.*

fun main() {
  val br = File("11022_A+B-8.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))
  
  lateinit var nums:List<Int>

  for(tc in 1..br.readLine().toInt()){
    nums = br.readLine().split(" ").map{it.toInt()}
    println("Case #${tc}: ${nums[0]} + ${nums[1]} = ${nums.sum()}")
  }
}