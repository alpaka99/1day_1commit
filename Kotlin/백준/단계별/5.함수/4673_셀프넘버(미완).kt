// 4673_셀프넘버

// 양의정수 n에 대해서
// d(n)을 n 과 n 의 각 자리수를 더하는 함수
// d(75) = 75 + 7 + 5 = 87
// n 은 생성자라고 함
// 생성자가 없는 숫자를 셀프넘버라고 함
// 10000보다 작거나 같은 셀프 넘버를 한줄에 하나씩

var arr:Array<Int> = arrayOf()
var visited: Array<Boolean> = arrayOf()

fun main(){
  // var nums = (0 until 10000)
  // var visited = (0 until 10000).map{_->0}
  var N = 10001
  visited = Array(N){false}

  for(i in 1 until visited.size){
    var num = i
    while(num < 10001 && visited[num] == false){
      num = d(num)
      if(num >= 10001){
        break
      }
      visited[num] = true
    }
  }

  for(i in 1 until visited.size){
    if(visited[i]==false){
      println(i)
    }
  }
}

fun d(num:Int):Int{
  var result = num
  var tmp = num

  while(tmp>9){
    result += tmp % 10
    tmp /= 10
  }
  result += tmp

  return result
}