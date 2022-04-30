// 1260_DFS와BFS

import java.io.*
import java.util.*

var adjList = mutableMapOf<Int, ArrayList<Int>>()

fun main() {
  val br = File("1260_DFS와BFS.txt").bufferedReader()
  // val br = BufferedReader(InputStreamReader(System.`in`))

  val (N, M, V) = br.readLine().split(" ").map{it.toInt()}

  

  repeat(M){
    val(start, end) = br.readLine().split(" ").map{it.toInt()}

    var temp = adjList.getOrDefault(start, ArrayList<Int>())
    var temp2 = adjList.getOrDefault(end, ArrayList<Int>())
    temp.add(end)
    temp2.add(start)
    

    adjList.put(start, temp)
    adjList.put(end, temp2)
  }

  var keys = adjList.keys
  for(key in keys){
    var temp = adjList.get(key)
    adjList.put(key, temp!!.sorted().toCollection(ArrayList<Int>()))
  }


  var dfsResult = dfs(N, V)
  println(dfsResult.joinToString(" "))

  var bfsResult = bfs(N, V)
  println(bfsResult.joinToString(" "))
}

fun dfs(n:Int, v:Int): ArrayList<Int> {
  var trail = ArrayList<Int>()
  var visited = BooleanArray(n+1)
  var stack = Stack<Int>()

  stack.push(v)

  while(stack.isNotEmpty()){
    var curNode = stack.pop()
    if(visited[curNode] == true){
      continue
    }
    visited[curNode] = true
    trail.add(curNode)
    

    var nxtNodes = adjList.getOrDefault(curNode, ArrayList<Int>())
    for(i in nxtNodes.size-1 downTo 0) {
      if(visited[nxtNodes[i]] == false) {
        stack.push(nxtNodes[i])
      }
    }
  }
  return trail
}


fun bfs(n:Int, v:Int): ArrayList<Int> {
var trail = ArrayList<Int>()
  var visited = BooleanArray(n+1)
  var deque = ArrayDeque<Int>()

  deque.offerLast(v)

  while(deque.isNotEmpty()){
    var curNode = deque.pollFirst()
    if(visited[curNode] == true){
      continue
    }
    visited[curNode] = true
    trail.add(curNode)
    

    var nxtNodes = adjList.getOrDefault(curNode, ArrayList<Int>())
    for(elem in nxtNodes) {
      if(visited[elem] == false) {
        deque.offerLast(elem)
      }
    }
  }
  return trail
}