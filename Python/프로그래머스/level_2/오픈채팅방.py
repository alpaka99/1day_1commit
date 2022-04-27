# 간단했던 문제

# 1. 주어진 record를 띄어쓰기 단위로 나눔
# 2. uid를 저장할때 dictionary를 사용하여 시간을 단축


def solution(record):
    answer = []
    tmp = []
    nickname_dict = {}
    
    # 들감 나감 써넣기 & 닉네임 딕셔너리 채워넣기
    for rec in record:
        cur = list(rec.split(' '))
        uid = cur[1]
        
        if cur[0] == "Enter":
            tmp.append([uid, "님이 들어왔습니다."])
            nickname_dict[uid] = cur[2]
        elif cur[0] == "Leave":
            tmp.append([uid, "님이 나갔습니다."])
        elif cur[0] == "Change":
            nickname_dict[uid] = cur[2]

        
    # 이제 여기서 answer 안에 있는 uid를 nickname으로 바꿔서 넣어주기
    for t in tmp:
        uid = t[0]
        id = nickname_dict[uid]
        answer.append(id + t[1])
        
        
    return answer



print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))
# ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]