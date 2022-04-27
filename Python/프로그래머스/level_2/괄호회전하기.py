# 우선 올바른 괄호 문자열인지 판별을 하는 방법을 찾아야할듯
# 소괄호 중괄호 대괄호 스택을 따로 만들어서 판별?
# -> No! 왜냐하면 괄호가 나오는 순서도 따져야 하기 떄문!
# -> 따라서 괄호 전체를 저장하는 하나의 스택으로 풀어야함

def check(s):
    # # 올바른 괄호 문자열인지 나타내는 flag
    # flag = True
    
    p = []
    p.append(s[0])
        
    for i in range(1,len(s)):
        if s[i] == "(":
            p.append(s[i])
        elif s[i] == ")":
            if len(p) >= 1 and p[-1] == "(":
                p.pop()
            else:
                return False
        elif s[i] == "{":
            p.append(s[i])
        elif s[i] == "}":
            if len(p) >= 1 and p[-1] == "{":
                p.pop()
            else:
                return False
        elif s[i] == "[":
            p.append(s[i])
        elif s[i] == "]":
            if len(p) >= 1 and p[-1] == "[":
                p.pop()
            else:
                return False
        else:
            print(-1)
    
    if len(p) == 0:
        return True
    else:
        return False
def solution(s):
    answer = -1
    
    cnt = 0
    for i in range(len(s)):
        s = s[1:] + s[0]
        # print(s)
        if check(s):
            cnt += 1
    
    answer = cnt
    return answer


print(solution("[](){}")) # 3
print(solution("}]()[{")) # 2
print(solution("[)(]"))   # 0
print(solution("}}}"))    # 0
print(solution("([{)}]")) # 0 -> 처음에 괄호마다 스택을 만들어서 이 테케를 틀림