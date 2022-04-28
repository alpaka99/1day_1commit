// 1018_체스판다시칠하기

// 다 window slicing 으로 떼어내서 몇개를 다시 칠해야하나 봐야할듯?


import java.io.*


fun main(){
  val br = File("1018_체스판다시칠하기.txt").bufferedReader()

  val (N, M) = br.readLine().split(" ").map{it.toInt()}


  // val matrix = Array(N, {i->br.readLine().toCharArray()})

  // val matrix2 = Array(N, {i->matrix[i].copyOf()})

  // matrix[0][0] = 'B'

  // for (i in 0 until matrix2.size) {
  //   for (j in 0 until matrix2[i].size) {
  //     print(matrix2[i][j]  ) 
  //   }
  //   println()
  // }

  val list1 = br.readLine().toCharArray()
  val arrlist1 = list1.toCollection(ArrayList<Char>())

  val list2 = arrlist1.toArray()
  val arrlist2 = list2.toCollection(ArrayList<Any>())

  list1[0] = 'X'

  list1.forEach{print(it)}
  println()

  println(arrlist1)

  list2.forEach{print(it)}
  println()
  
  println(arrlist2)





}