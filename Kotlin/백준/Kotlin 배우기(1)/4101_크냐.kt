// import java.io.*

// fun main() {
//   val br = File("4101_크냐.txt").bufferedReader()
//   // val br = BufferedReader(InputStreamReader(System.`in`))

//   while(true){
//     var (a, b) = br.readLine().split(" ").map{it.toLong()}

//     if(a == 0L && b == 0L) break

//     if(a > b)println("YES")
//     else println("NO")
//   }
  
// }
import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    while (true) {
        val a = nextLong()
        val b = nextLong()

        if (a == 0L && b == 0L) break

        if (a > b) println("Yes")
        else println("No")
    }
}