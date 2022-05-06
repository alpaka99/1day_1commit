// -던-
// 탐험을 시작하기 위한 "최소 필요 피로도", 던전 탐험을 마쳤을 떄 소모되는 "소모 피로도"
// 최대한 많은 던전을 탐험
// 근데 dungeons 의 갯수가 8개 밖에 안되서 다 permutation 돌려도 될 듯?

class Solution {
    var maxVal = 0 // 가장 많이 돌은 던전 기록
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        
        
        
        var visited = BooleanArray(dungeons.size)
        permutation(dungeons, visited, k, 0)
        
        answer = maxVal
        
        return answer
    }
    
    fun permutation(dungeons:Array<IntArray>, visited:BooleanArray, k:Int, cnt:Int):Unit {
        if(visited.count{it == true} == visited.size){ // 재귀 탈출조건
            if(cnt > maxVal){
                maxVal = cnt
            }
            return
        }
        
        for(i in 0 until visited.size){
            if(visited[i] == false){ // 방문 안한 던전인데
                
                visited[i] = true // 방문 전처리
                
                if(dungeons[i][0] <= k){ // 방문 가능
                    permutation(dungeons, visited, k-dungeons[i][1], cnt+1)
                }
                else{
                    permutation(dungeons, visited, k, cnt)
                }
                
                visited[i] = false // 방문 후처리
                
            }
        }
    }
}