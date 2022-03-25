# cities 100,000개 -> 꽤 많은 양
# 캐시 교체 알고리즘은 least recently used
# cache hit 실행시간 1, cache miss 실행시간 5

# cacheSize가 0인 경우를 처음에 생각 못함
# 글자가 lower랑 upper가 섞여 있는거 생각 못함
# 이런 boundary 값 잘 보자. 이번 문제는 친절했는데 다른 문제는 친절하지 않으면 테케 다틀림

# python에서 del list[i] -> list의 i번쨰 원소를 삭제
# string.lower() -> 소문자로 변경
# deque에도 remove가 있네?? 이걸 쓰면 더 쉬웠겠다

def solution(cacheSize, cities):
    answer = 0
    cache = ["" for _ in range(cacheSize)]
    if cacheSize == 0:
        return len(cities)*5
    
    for city in cities:
        n_city = city.lower()
        if n_city in cache:
            cache.remove(n_city)
            cache.append(n_city)
            answer += 1
        else:
            del cache[0]
            cache.append(n_city)
            answer += 5
            
        
    return answer


print(solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"])) # 50
print(solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"])) # 21
print(solution(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"])) # 60
print(solution(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"])) # 52
print(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"])) # 16
print(solution(0, 	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"])) # 25



# 1. deque에도 remove 기능이 있다!
# 2. deque의 maxlen = n 을 설정해 놓으면 
# append 할 때 deque의 사이즈가 n 이상이면 자동으로 맨 앞에것을 pop한다!
from collections import deque

def solution2(cacheSize, cities):
    answer = 0
    cache = deque(maxlen=cacheSize)
    if cacheSize == 0:
        return len(cities)*5
    
    for city in cities:
        n_city = city.lower()
        if n_city in cache:
            cache.remove(n_city)
            cache.append(n_city)
            answer += 1
        else:
            cache.append(n_city)
            answer += 5
            
        
    return answer


print(solution2(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"])) # 50
print(solution2(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"])) # 21
print(solution2(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"])) # 60
print(solution2(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"])) # 52
print(solution2(2, ["Jeju", "Pangyo", "NewYork", "newyork"])) # 16
print(solution2(0, 	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"])) # 25

