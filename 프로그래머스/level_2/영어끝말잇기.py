# 끝말잇기
# 끝말이 안이어지거나 이전에 말한 단어를 말하면 탈락
# 가장 먼저 탈락한 사람과 몇번째 차례에 탈락하는지를 구해서 return
# n 사람, words 단어들
# words는 100단어 이하 -> 생각보다 단어 수가 적으니까 많아야 100*100 10000임
# [번호, 차례] 형태의 return, 탈락하는 사람이 없으면 [0, 0] return
def solution(n, words):
    answer = [0, 0]
    
    # 체크해야하는것은 2가지
    # 1. 이전 단어의 마지막 글자랑 지금 시작하는 단어의 글자가 같은지
    # 2. 이전에 나왔던 단어인지
    used_words = []
    used_words.append(words[0])
    for i in range(1, len(words)):
        if words[i-1][-1] == words[i][0]: # 1번조건
            if not(words[i] in used_words): # 2번조건
                used_words.append(words[i])
            else:
                # print(words[i-1], words[i], used_words, "이미 사용한 단어")
                answer[0] = (i % n) + 1
                answer[1] = (i // n) + 1
                return answer
        else:
            # print(words[i-1], words[i], used_words, "끝말 안이어짐")
            answer[0] = (i % n) +1
            answer[1] = (i // n) + 1
            return answer
    

    return answer


print(solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"])) # [3, 3]
print(solution(5, 	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"])) # [0, 0]
print(solution(2, ["hello", "one", "even", "never", "now", "world", "draw"])) # [1, 3]



# 다른 사람 풀이

# 오호... 방법은 같은데 진짜 깔끔하다
# words[p] in words[:p] 이 부분 깔끔하네

def solution(n, words):
    for p in range(1, len(words)):
        if words[p][0] != words[p-1][-1] or words[p] in words[:p]: return [(p%n)+1, (p//n)+1]
    else:
        return [0,0]