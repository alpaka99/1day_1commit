# 리스트에서 가장 작은 수 와 그 다음으로 작은 수를 꺼낸 후
# 연산을 한 값을 다시 리스트에 넣어주는 문제
# 처음에는 그냥 sort를 사용해서 했는데 이러면 시간초과가 걸림
# 항상 가장 작은 값을 반환해주는 heap을 써야함

import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    
    answer = 0
    
    while len(scoville) >= 2:
        answer += 1
        hot_1st = heapq.heappop(scoville)
        hot_2nd = heapq.heappop(scoville)
        
        new_hot = hot_1st + hot_2nd*2
        
        heapq.heappush(scoville, new_hot)
        
        if scoville[0] >= K:
            return answer
        
        
    if scoville[0] >= K:
        return answer
    else:
        return -1
    
    return scoville

print(solution([1, 2, 3, 9, 10, 12], 7)) # 2


    