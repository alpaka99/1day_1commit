// 10828_스택.kt
import java.io.*

var stack = ArrayList<Int>()

fun main() {
  val br = File("10828_스택.txt").bufferedReader()

  val N = br.readLine().toInt()

  repeat(N) {
    val dat = br.readLine().split(" ")
    if(dat.size == 1) {
      when(dat[0]){
        "pop" -> pop()
        "size" -> size()
        "empty" -> isEmpty()
        "top" -> top()
        else -> println("틀림")
      }
    } else {
      push(dat[1].toInt())
    }
  }
}

fun push(n:Int):Unit {
  stack.add(n)
}

fun isEmpty():Int {
  if(stack.size == 0) {
    println(1)
    return 1
  } else { 
    println(0)
    return 0
  }
}

fun pop():Unit {
  if(top() == true){
    stack.remove(stack.size-1)
  }
}

fun size():Unit {
  println(stack.size)
}

fun top():Boolean {
  if(isEmpty()==1){
    println("TOP op")
    println(-1)
    return false
  } else {
    println(stack[stack.size-1])
    return true
  }
}