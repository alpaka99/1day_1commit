# 이거는 브루트 포스로 모든 경우를 다 따져봐야하네
# 숫자 5개면 연산 5개
# 5개에 대해 모든 경우를 구하고 해당 경우에 대해서 다 해보면 될듯?
# 20개가 맥스면 총 2^20 = 천만단위 할만한가?

# -> 문제의 조건을 따져서 적당한 시간 내에 가능한지 안한지를 따져본게 주요했다.

answer = 0
def brute(numbers, target, cur_value, level):
    # 탈출조건
    if level >= len(numbers):
        if cur_value == target:
            global answer
            answer += 1
        return
        
    brute(numbers, target, cur_value+numbers[level], level+1)
    brute(numbers, target, cur_value-numbers[level], level+1)
    
    return

def solution(numbers, target):
    brute(numbers, target, 0, 0)    
    
    return answer


print(solution([1, 1, 1, 1, 1], 3))

