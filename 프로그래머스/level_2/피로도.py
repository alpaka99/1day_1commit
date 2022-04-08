# 일정 피로도를 사용해서 던전을 탐험
# 최소 필요 피로도, 소모 피로도

# 최대한 많은 던전을 탐험

# 던전 갯수는 1 이상 8 이하
# 각 행은 [최소 필요 피로도, 소모 피로도]

# 탐험할 수 있는 최대 던전 수는?

# 남은 던전들 중에서 최소 필요 피로도를 만족하면서 소모 피로도가 가장 작은걸 매번 골라주면 되겠다
# 아님 왜냐하면 어떤 던전 하나를 가서 다른 던전의 최소필요피로도를 만족 못하는 경우가 발생
# 그러면 걍 permutations으로 다 돌아야하나?

from itertools import permutations


def solution(k, dungeons):
    answer = -1
        
    
    
    num_list = [i for i in range(len(dungeons))]
    perms = list(permutations(num_list))
    
    
    max_val = 0
    for perm in perms:
        pyro = k
        cnt = 0
        for i in range(len(perm)):
            least_pyro, consume_pyro = dungeons[perm[i]]
            if least_pyro <= pyro:
                pyro -= consume_pyro
                cnt += 1
        max_val = max(max_val, cnt)
    
    answer = max_val
    return answer



print(solution(80, [[80,20],[50,40],[30,10]])) # 3