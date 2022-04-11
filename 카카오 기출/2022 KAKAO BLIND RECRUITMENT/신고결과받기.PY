# 각 유저는 한번에 한명의 유저 신고
# 서로 다른 유저를 계속해서 신고 가능
# 동일 유저에 대한 신고 횟수는 1회로 처리
# k 번 이상 신고된 유저는 게시판 이용이 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
# 마지막에 한꺼번에 게시판 이용정지를 시키면서 정지 메일을 발송

# 이용자의 ID : id_list
# 각 이용자가 신고한 이용자의 ID 정보 : report
# 정지 기준 : k
# 각 유저별로 처리결과 리스트 반환
def solution(id_list, report, k):
    answer = []
    
    
    id_dict = {} # 각 id 에 관하여 dict 를 만들어줌
    answer_dict = {} # 정지했음 메일을 받은 횟수를 저장하는 dict
    
    for id in id_list:
        id_dict[id] = set()
        answer_dict[id] = 0
    
    # data 넣기
    for elem in report:
        reporter, reported = elem.split()
        id_dict[reported].add(reporter)
    
    # k 번 이상 신고된 id에 대하여 
    for id in id_list:
        if len(id_dict[id]) >= k:
            while id_dict[id]:
                answer_dict[id_dict[id].pop()] += 1
    
    for id in id_list:
        answer.append(answer_dict[id])
    
    return answer



print(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2)) # [2, 1, 1, 0]
print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3)) # [0, 0]
