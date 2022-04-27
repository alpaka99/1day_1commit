# 이진탐색 문제인듯
# N값이 1024*1024 -> 1초 안에는 끝날듯?

# 다른풀이가 내가 처음에 생각했던 방식이랑 유사함. 수학적으로 숫자를 다루는것
# 내가 제출한 풀이는 시뮬레이션에 가까움

def solution1(n,a,b):
    answer = 0
    
    num_list = [i for i in range(1, n+1)]
    
    
    cnt = 0
    
    # 어느정도까지 함께 갈라지지 않고 갈 수 있는지 구함
    N = len(num_list)
    while N >= 1:
        left = num_list[:N//2]
        right = num_list[N//2:]
        
        if a in left and b in left:
            num_list = left[:]
            cnt += 1
        elif a in right and b in right:
            num_list = right[:]
            cnt += 1
        else:
            break
        
        N = len(num_list)
    
    
    # 완전히 갈라졌을때 몇번인지를 구함
    num = 2
    num_cnt = 0
    while num <= n:
        num *= 2
        num_cnt += 1
    
        
    # 완전 갈라졌을떄 - 현재 숫자들이 같이 가는 횟수
    answer = num_cnt - cnt
    return answer


print(solution1(8, 4, 7)) # 3



### 다른 풀이
# 이겼을때 다음에 얻는 번호를 알 수 있음
# -> 따라서 같은 번호를 얻을 때 까지 연산을 해주면 됨
def solution2(n,a,b): 
    cnt=0 
    while a!=b: 
        a,b= (a//2)+(a%2), (b//2)+(b%2) 
        cnt+=1

    return cnt

print(solution2(8, 4, 7))



# 시간 차이 테스트 32
# 내 풀이 :  103.82ms
# 다른 풀이 : 0.00ms
# ... 시간 차이 현격하네