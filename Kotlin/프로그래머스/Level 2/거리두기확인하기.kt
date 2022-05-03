// P: 응시자가 앉음, O: 빈 테이블, X: 파티션
// -> 응시자가 앉은곳 + 4방 -> -1, 파티션 있는 칸 -> +100
// 해서 나온 배열의 음수인 곳이 있나 확인
// 사람이 앉은 위치가 아닌 파티션이 있어야 하는 위치에 파티션이 있나 없나 확인하는것!
class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(place in places) {
            var matrix = ArrayList<CharArray>()
            var checkMatrix = ArrayList<IntArray>() // 숫자 체크를 위한 배열
            var drPerson = arrayOf<Int>(-1, 0, 1, 0, 0) // 4방 + 자신
            var dcPerson = arrayOf<Int>(0, 1, 0, -1, 0)
            // var drPartition = arrayOf<Int>(-1, 1, 1, -1) // 대각선 4방
            // var dcPartition = arrayOf<Int>(1, 1, -1, -1)
            
            for(str in place){
                matrix.add(str.toCharArray())
            }
            
            
            for(i in 0 until 5){ // 숫자 체크 배열 초기화
                var newArr = IntArray(5)
                checkMatrix.add(newArr)
            }

            for(i in 0 until 5){ // 사람 앉거나 파티션이 있으면 연산
                for(j in 0 until 5){
                    if(matrix[i][j] == 'P'){ // 사람이 앉았으면
                        for(k in 0 until 5){ // 4방 + 자신
                            var nr = i + drPerson[k]
                            var nc = j + dcPerson[k]
                            
                            if(!(nr in 0 until 5 && nc in 0 until 5)){ // 범위 제한
                                continue
                            }
                            
                            checkMatrix[nr][nc] -= 1 // -1 을 해줌
                        }
                    }
                    else if(matrix[i][j] == 'X'){ // 파티션이 있으면
                        checkMatrix[i][j] += 100 // 100 을 해줌
                    }
                }
            }
            // checkMatrix.forEach{
            //     println(it.joinToString())
            // }
            // println("-".repeat(20))
            
            // 이제 matrix를 돌면서 사람 앉은곳에 음수가 있나 확인
            var flag = true
            base@ for(i in 0 until 5){
                for (j in 0 until 5){
                        if(checkMatrix[i][j] <= -2){
                            // println("${i}, ${j}")
                            answer += 0
                            flag = false
                            break@base
                        }
                    }
            }
            
            if (flag) {
                answer += 1
            }
    }
    return answer
    }
}