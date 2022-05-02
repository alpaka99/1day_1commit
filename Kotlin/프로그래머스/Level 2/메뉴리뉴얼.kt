// 조합으로 모든 글자 경우를 구하고, 글자 갯수 중 가장 많이 나온것들을 골라서 반환

class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        
        var menuMap = mutableMapOf<String, Int>()
        
        for(order in orders){
            var list = order.toList().sorted()
            for(i in 2..order.length){
                var combs = combination(list, i)
                
                for(comb in combs){
                    var key = comb.joinToString("")
                    
                    if(menuMap.containsKey(key)){
                        menuMap.put(key, menuMap[key]!!+1)
                    }
                    else{
                        menuMap[key] = 1
                    }
                }
            }
        }
        
        for(number in course){
            var courseMap = menuMap.filterKeys{it.length==number}.filterValues{it>=2}
            
            var max = courseMap.values.maxOrNull()
            
            for(key in courseMap.keys){
                if(courseMap[key] == max){
                    
                    answer += key
                }
            }
        }
        answer.sort()
        return answer
    }
}

fun<T> combination(el:List<T>, limit:Int = el.size, fin:List<T> = listOf(), index:Int = 0):List<List<T>> {
	return if (fin.size >= limit) {
		listOf(fin)
	} else {
		el.slice(index until el.size).flatMapIndexed {i:Int, t:T -> combination(el,limit,fin+t,index+i+1)}
	}
}