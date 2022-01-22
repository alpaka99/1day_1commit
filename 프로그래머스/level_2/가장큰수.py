# 주어진 배열 numbers의 숫자 조합중 가장 큰 수를 return

# numbers의 길이는 1 이상 100,000 이하
# numbers의 원소는 0 이상 1,000 이하
# 정답이 너무 클 수 있으니 문자열로 return



# 1. 맨 앞자리가 큰 순서대로 정렬을 한 후 역으로 합쳐서 만들자 
# -> 맨 앞자리가 같은 숫자 내부에서는 문제를 만족하는 규칙을 찾기가 어려움

# 2. 순열로 가능한 숫자를 전부 다 만들어 본 다음 비교하여 가장 큰 수를 찾자
# -> 시간 초과

# 3. 인터넷에서 찾은 방법 : 원소들이 1000 이하이므로 모든 숫자를 4자리로 맞춘 후 대소비교를 한다
# -> 1. 과 같은 문제 발생  ex) 12, 121

# 4. 인터넷에서 찾은 방법2 : 원소들을 4자리로 만들때 0을 붙히는게 아니라 그 숫자를 반복해서 4자리 숫자로 생성
 
def solution(numbers):
    answer = ''
    
    new_numbers = [] # (원래 숫자, 4자리로 만든 숫자)의 튜플을 저장할 배열

    # 숫자 4자리로 늘린 후 튜플형태로 저장하기
    for i in range(len(numbers)):
        new_numbers.append((numbers[i], (str(numbers[i])*4)[:4]))
    

    new_numbers.sort(reverse = True, key = lambda x : x[1]) # 4자리로 늘린 숫자를 기준으로 배열 역정렬
    
    # 정렬된 원래 숫자들을 answer 변수에 더함
    for elem in new_numbers:
        answer += str(elem[0])
    
    answer = str(int(answer)) # [0, 0, 0, 0] -> 0000 으로 출력되는걸 방지하기 위한 처리

    return answer


# 굉장히 깔끔한 풀이
# 나와 다른 점 : map을 써서 코드 길이를 줄임

# lambda x : x*3 은 왜 그렇게 되는지 아직 파악중 
# str인 숫자는 크기를 비교하면 전체를 int로 변환후 숫자 크기를 비교하는게 아니라
# 맨 앞부터 숫자를 1개씩 비교해서 차이가 나는 시점에서의 대소를 비교
# 따라서 "33" > "303030" 이 됨

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)

    return str(int(''.join(numbers)))

print(solution([6, 10, 2])) # 6210
print(solution([3, 30, 34, 5, 9])) # 9534330

