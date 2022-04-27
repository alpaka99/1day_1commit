# 완전탐색을 해야했던 문제

# 가운데는 노란색, 테두리 1줄은 갈색
# -> 노란색을 적당히 배치하고 그거의 가로+2, 세로+2 하면 되겠다
# -> 그래도 하나씩 다 찾아봐야하는게 갈색의 수에 따라서 노란색의 모양도 달라짐..

from math import sqrt
def solution(brown, yellow):
    answer = []
    root = int(sqrt(yellow))
    
    
    
    # 만약 제곱수면..
    if root**2 == yellow:
        answer = [root+2, root+2]
        return answer
    
    # 하나씩 다 찾아봐야하는경우
    
    for garo in range(yellow, root-1, -1):
        if yellow % garo == 0:
            cero = yellow / garo
            if garo < cero:
                break
        else:
            continue
        
        if (garo+cero)*2 + 4 == brown:
            answer = [garo+2, cero+2]
            break
        

    return answer


print(solution(10, 2)) # [4, 3]
print(solution(8, 1)) # [3, 3]
print(solution(24, 24)) # [8, 6]



# 근의 공식으로 문제를 푼 방법
# 길이 넓이 공식 각각으로 식 두개 만들고 변수가 2개 존재하니까 그걸로 풀어버림
import math
def solution2(brown, yellow):
    w = ((brown+4)/2 + math.sqrt(((brown+4)/2)**2-4*(brown+yellow)))/2
    h = ((brown+4)/2 - math.sqrt(((brown+4)/2)**2-4*(brown+yellow)))/2
    return [w,h]

print(solution2(10, 2)) # [4, 3]
print(solution2(8, 1)) # [3, 3]
print(solution2(24, 24)) # [8, 6]