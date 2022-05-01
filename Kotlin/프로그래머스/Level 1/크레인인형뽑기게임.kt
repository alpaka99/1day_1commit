import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var stack =  Stack<Int>()
        
        
        var newBoard = rotate(board)
        
        for(move in moves){
            if(newBoard[move-1].isNotEmpty()){
                var curDoll = newBoard[move-1].pop()
                
                if(stack.isNotEmpty()){
                    if(curDoll == stack.peek()){
                    stack.pop()
                    answer+=2
                    }
                    else {
                        stack.push(curDoll)
                    }    
                }
                else {
                    stack.push(curDoll)
                }
                
            }
            else {
                continue
            }            
        }
        return answer
    }
    
    fun rotate(board: Array<IntArray>):ArrayList<Stack<Int>> {
        var N = board.size
        var newBoard = ArrayList<Stack<Int>>()
        
        for(j in 0 until N){
            var newArr = Stack<Int>()
            for(i in N-1 downTo 0){
                if(board[i][j] != 0){
                    newArr.push(board[i][j])    
                }
            }
            newBoard.add(newArr)
        }
        
        return newBoard
    }
    
}