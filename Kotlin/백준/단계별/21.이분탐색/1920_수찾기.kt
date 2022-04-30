// 1920_이분탐색

import java.io.*


fun main() {
  // val br = File("1920_수찾기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  var arr = br.readLine().split(" ").map{it.toInt()}.toSet()
  // arr = arr.sorted()

  val M = br.readLine().toInt()

  val dat = br.readLine().split(" ").map{it.toInt()}

  for(elem in dat){
    if(arr.contains(elem)){
      println(1)
    }
    else{
      println(0)
    }
  }

  // for(elem in dat){
  //   var start = 0
  //   var end = N-1

  //   base@ while(true){
  //     println("${start} ${end} ${elem}")
  //     if(start == end) {
  //       if(arr[start] == elem){
  //         println(1)
  //         break@base
  //       }
  //       else {
  //         println(0)
  //         break@base
  //       }
  //     }

  //     var middle = (start+end)/2

  //     if(arr[middle] == elem){
  //       println(1)
  //       break@base
  //     }
  //     else {
  //       if(arr[middle] > elem) {
  //         end = middle - 1
  //       }
  //       else {
  //         start = middle + 1
  //       }
  //     }
  //   }
  // }

}

// fun binarySearch(start:Int, end:Int, num:Int):Boolean {
//   if(start == end){
//     if(arr[start] == num){
//       return true
//     }
//     else {
//       return false
//     }
//   }

//   val middle = (start+end)/2

//   if(arr[middle] == num){
//     return true
//   }
//   else {
//     if(num > arr[middle]){
//       return binarySearch(middle+1, end, num)
//     }
//     else{
//       return binarySearch(start, middle-1, num)
//     }
//   }
// }