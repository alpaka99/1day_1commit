// 이거 그거네 전체 경우의 수 - 1
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var clothMap = mutableMapOf<String, MutableSet<String>>()
        
        for(cloth in clothes){
            var(name, category) = cloth
            
            if(!(clothMap.containsKey(category))){
                clothMap.put(category, mutableSetOf<String>())
                
            }
            clothMap[category]!!.add(name)
        }
        
        for(key in clothMap.keys){
            var number = clothMap[key]!!.size + 1
            answer *= number
        }
        
        answer -= 1
        
        return answer
    }
}