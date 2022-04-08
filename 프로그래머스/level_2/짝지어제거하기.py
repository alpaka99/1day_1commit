# 문자열의 앞에서부터 쭉 훑으면서 같은게 2개 연속으로 나오면 멈추고 해당 위치에서 2개 제거
# 그리고 다시 붙힘
# 다시 처음부터 시작
# 만약 끝까지 검사가 끝났는데 문자열이 남아있으면 성공적 수행 아님

# 일단 문자열의 길이가 엄청 큼 -> 한방에 지울거는 다 지워야겠는데
# 아니면 divide and conquer 방법? -> 일단 이 방향이 맞음

# def dnc(s):
#     length = len(s)
#     if length <= 1:
#         return s
    
    
#     half = length//2
    
#     l = s[:half]
#     r = s[half:]
    
#     left = dnc(l)
#     right = dnc(r)
    
    
    
#     # 이제 합칠때 체크 -> 합칠때 문제가 되는건 left와 right의 합쳐지는 부분 -> 여기만 계속 탐색해보자
#     while True:
#         if left == "" or right == "":
#             return left+right
        
        
#         if left[-1] == right[0]:
#             left = left[:-1]
#             right = right[1:]
#         else:
#             break
            
#     return left+right
        
        

# def solution(s):
#     answer = 1
    
#     result = dnc(s)
    
#     if len(result) >= 1:
#         answer = 0
    
#     return answer


# 아 좀 짜증난다 너무 쉽게 풀리네 이렇게 하니까
# 내가 recursive 하게 divide and conquer를 하는 방법을
# 이 사람은 stack을 이용해서 한글자씩 비교하면서 간단하게 해버림
# 이 사람의 로직
# 문자를 제거할 때마다 처음부터 다시 검사 -> 비효율적
# 따라서 한번에 검사를 하기 위해서 top과 새로 입력될 문자를 비교해서 
# 같은 문자라면 제거, 아니면 스텍에 남겨서 다음 문자랑 비교
def solution(s):
    
    stack = []
    stack.append(s[0])

    for i in range(1, len(s)):
        if len(stack) > 0 and stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])

    if len(stack) == 0:
        return 1
    else:
        return 0

print(solution("baabaa")) # 1
print(solution("cdcd")) # 0