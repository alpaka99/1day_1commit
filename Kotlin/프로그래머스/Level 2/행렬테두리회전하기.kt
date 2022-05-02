import java.util.*




class Solution {
    
    
    var matrix = ArrayList<IntArray>()
    var cpyMatrix = ArrayList<IntArray>()
    var deque = ArrayDeque<Int>()
    var smallNums = ArrayList<Int>()

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {    
        
        
        for(i in 0 until rows){
            var tmpArray = IntArray(columns)
            for (j in 0 until columns){
                tmpArray[j] = (i*columns+j+1)
            }
            matrix.add(tmpArray)
            cpyMatrix.add(tmpArray.copyOf())
        }
        
        for(querie in queries){
            rotate(querie)
        }
        
        var answer = smallNums.toIntArray()
        return answer
    }
    
    fun rotate(querie:IntArray) {
            var x1 = querie[0]-1
            var y1 = querie[1]-1
            var x2 = querie[2]-1
            var y2 = querie[3]-1
        
            for(j in y1 until y2){
                deque.add(cpyMatrix[x1][j])
            }
            for(i in x1 until x2){
                deque.add(cpyMatrix[i][y2])
            }
            for(j in y2 downTo y1+1){
                deque.add(cpyMatrix[x2][j])
            }
            for(i in x2 downTo x1+1){
                deque.add(cpyMatrix[i][y1])
            }
            // println(deque)
            var min = deque.minOrNull()
            if(min != null){
                smallNums.add(min)
            }
            
            deque.offerFirst(deque.pollLast())

            for(j in y1 until y2){
                cpyMatrix[x1][j] = deque.pollFirst()
            }
            for(i in x1 until x2){
                cpyMatrix[i][y2] = deque.pollFirst()
            }
            for(j in y2 downTo y1+1){
                cpyMatrix[x2][j] = deque.pollFirst()
            }
            for(i in x2 downTo x1+1){
                cpyMatrix[i][y1] = deque.pollFirst()
            }
    }
}