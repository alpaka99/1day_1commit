// 한자리 숫자가 적힌 종이 조각이 흩어져 있음. 
// 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내자

// numbers 를 쪼개서 만들 수 있는 모든 숫자를 구하고
// 해당 숫자가 소수인지 아닌지를 판단하자. (제곱근까지 약수가 있는지 없는지)

import kotlin.math.*

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        var charNumbers = numbers.toCharArray().toList()
        
        // 조합으로 모든 숫자 조합을 구하고
        // 순열로 모든 경우의 수를 구할까?
        
        var numSet = mutableSetOf<Int>()
        
        for(i in 1..charNumbers.size){
            var combs = combination(charNumbers.toList(), i) // i 자리의 조합
            
            
            combs.forEach{ // 각각의 조합에 대해 순열을 돌림
                var perms = permutation(it)
                
                perms.forEach{ // 각각 나온 순열을 숫자로 변환 후 set 에 넣음
                    numSet.add(it.joinToString("").toInt())
                }
            }
        }
        
        numSet = numSet.filter{it>=2}.toMutableSet()
        
        for(number in numSet){
            if(checkPrime(number)){
                answer++
            }
        }
        
        
        return answer
    }
    
    fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    }
    
    fun <T> combination(el:List<T>, limit:Int = el.size, fin:List<T> = listOf(), index:Int = 0):List<List<T>> {
	return if (fin.size >= limit) {
		listOf(fin)
	} else {
		el.slice(index until el.size).flatMapIndexed {i:Int, t:T -> combination(el,limit,fin+t,index+i+1)}
	}
}
    fun checkPrime(number: Int): Boolean {
        for(i in 2..sqrt(number.toDouble()).toInt()){ // number 의 제곱근 까지의 숫자에 대하여
            if(number % i == 0){ // 만약 나눠 떨어진다? -> 약수가 있다 -> 소수가 아니다
                return false
            }
        }
        return true // -> 소수이다
    }
}