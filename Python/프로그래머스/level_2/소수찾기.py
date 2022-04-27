# 방법 1. 가장 큰 수를 찾고 그 숫자 까지의 숫자들 중 numbers의 글자들로 만들 수 있는 수를 찾고, 그 숫자가 소수인지 확인
# -> 뭔가 비효율적인데?

# 방법 2. numbers를 permutaion을 써서 재조합한 후 각 숫자가 소수인지 확인


# 소수를 찾을떄는 항상 어떤 방법이 더 효율적인지 고려 잘 해야할듯.. 시간이 오래 걸리는 작업
from itertools import permutations
import math
# 소수인지 아닌지 체크해주는 함수
# 소수인지 아닌지 -> 2에서 루트 n +1 까지의 숫자 중 n의 약수가 있으면 소수가 아님
def prime_check(num):
    if num <= 1:
        return False
    
    root_num = int(math.sqrt(num))

    for i in range(2, root_num+1):
        if num % i == 0:
            return False

    return True

def solution(numbers):
    answer = 0
    letter_list = []
    
    for letter in numbers:
        letter_list.append(letter)
    
    # 구할 수 있는 모든 순열을 구하고
    total_perms = []
    for i in range(1, len(letter_list)+1):
        perms = list(permutations(letter_list, i))
        total_perms.append(perms)
    
    
    numset = set()
    # 숫자로 만든 후
    for perms in total_perms:
        for perm in perms:
            num = ""
            for letter in perm:
                num += letter

            num = int(num)
            numset.add(num)
                     
    numlist = list(numset)
    
    for num in numlist:
        if prime_check(num):
            answer += 1
    return answer


print(solution("17")) # 3
print(solution("011")) # 2


# 참고
# 루트한 숫자로 소수를 찾는 방법과 그냥 하나씩 다 보면서 찾는데 걸리는 시간 차이
# 프로그래머스 tc 10 기준
# 루트 n 법 사용 : 5.66ms
# 사용안함 : 1985.72ms
# -> 차이가 어마어마하다..!