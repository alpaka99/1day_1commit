// 2630_색종이만들기


// 하얀색, 파란색으로 칠해진 정사각형의 종이를 잘라서
// 각각의 색을 가진 작은 색종이로 만드는것
// 가로 세로를 반으로 쪼개서 나눔
// 최종적으로 나온 하얀색 종이랑 파란색 종이의 갯수를 구하라

// 재귀적으로 짜면 될듯?

import java.io.*

var white = 0
var blue = 0

var matrix = ArrayList<ArrayList<Int>>()

fun main() {
  // val br = File("2630_색종이만들기.txt").bufferedReader()
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  repeat(N){
    var temp = br.readLine().split(" ").map{it.toInt()}.toCollection(ArrayList<Int>())

    matrix.add(temp)
  }

  dnc(0, 0, matrix.size)

  println(white)
  println(blue)
}

fun dnc(rStart:Int, cStart:Int, size:Int):Unit {
  if(check(rStart, cStart, size) == 1){
    blue++
    return
  }
  else if(check(rStart, cStart, size) == 0){
    white++
    return
  }
  else { // 다 같은 색이 아니므로 재귀적으로 더 깊게 들어감
    dnc(rStart, cStart, size/2)
    dnc(rStart+size/2, cStart, size/2)
    dnc(rStart, cStart+size/2, size/2)
    dnc(rStart+size/2, cStart+size/2, size/2)
  }
  return
}


// 주어진 범위 안에 있는 사각형이 전부 다 같은 색깔로 채워졌는지 확인하는 함수
// 파란색: 1 반환, 하얀색: 0 반환, 다 같은 색이 아님: -1 반환
fun check(rStart:Int, cStart:Int, size:Int):Int{
  val std = matrix[rStart][cStart]
  for(i in rStart until rStart+size){
    for(j in cStart until cStart+size){
      if(std != matrix[i][j]){
        return -1
      }
    }
  }

  return std
}