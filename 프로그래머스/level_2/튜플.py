## 입력으로 주어지는 string에서 내가 원하는 숫자를 정제하는게 힘들었던 문제
# 가장 많이 나온 숫자가 배열의 앞자리에 와야하는 이상한 조건이 숨어있던 문제

# 1. 주어진 s에서 숫자만을 정제한다
# 2. 정제된 숫자를 set에 넣어서 겹치지 않게 한다
# 3. 다시 정제된 숫자를 돌면서 dictionary에 갯수를 세준다
# 4. dictionary의 key들을 갯수 순서로 sort해서 반환한다

def solution(s):
    answer = []
    
    s = s[1:-1]
    
    s2 = []
    pos = 0
    while pos < len(s):
        start = pos
        if s[pos] == "{":
            while not(s[pos]) == "}":
                pos += 1
            s2.append(s[start:pos+1])
        pos += 1
    
    s3 = []
    for i in range(len(s2)):
        tmp = s2[i].lstrip("{")
        tmp2 = tmp.rstrip("}")
        tmp3 = tmp2.split(",")
        
        result = []
        for ele in tmp3:
            result.append(int(ele))
        
        s3.append(result)
    
    #### 여기까지가 숫자 정제 ########
    numset = {}
    
    for ele in s3:
        for elem in ele:
            # print(elem)
            if numset.get(elem) == None:
                numset[elem] = 0
                
            else:
                numset[elem] += 1

    numtuple = []
    for key in numset:
        numtuple.append((key, numset[key]))
    
    
    numtuple.sort(reverse = True, key = lambda x : x[1])
    
    answer = []
    for ele in numtuple:
        answer.append(ele[0])
    
    return answer
    
    
    
print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")) # [2, 1, 3, 4]
print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")) # [2, 1, 3, 4]
print(solution("{{20,111},{111}}")) # [111, 20]
print(solution("{{123}}")) # [123]
print(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")) # [3, 2, 4, 1]


# 다른 풀이 1
# 숫자 정제하는 부분을 깔끔하게 함

def solution2(s):
    answer = []
    s = s[2:-2]
    s = sorted(s.split("},{"), key = lambda x: len(x))

    for i in s:
        i_ = i.split(',')
        for j in i_:
            if int(j) not in answer:
                answer.append(int(j))
    return answer



# 다른풀이 2
# 정규표현식을 사용해서 풀었다고 하는데 아직은 이해가 안감..
# Counter 어떤 단어가 주어졌을떄 단어에 포함된 알파벳을 세주는 함수 -> Collections에 있음
#  -> print(Counter("Hello world")) -> Counter({'l': 3, 'o': 2, 'H': 1, 'e': 1, ' ': 1, 'w': 1, 'r': 1, 'd': 1})



import re
from collections import Counter

def solution3(s):
    s = Counter(re.findall('\d+', s))
    return list(map(int, [k for k, v in sorted(s.items(), key=lambda x: x[1], reverse=True)]))



