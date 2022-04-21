fun main() {
  val str = "a b c d"

  val st = str.split(" ")

  println("${st::class.simpleName}")

  for(i in 0..10 step 2){
    println(i)
  }
}