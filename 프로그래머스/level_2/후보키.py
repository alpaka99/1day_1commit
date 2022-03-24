# relation은 최대 20 x 8 = 160인 배열
# -> 전체 다 돌아도 괜찮을지도?
# 그러면 세로로 돌아서 우선은 unique 한것들을 파악
# 그러고 나서 최소성을 만족하는거 파악?


# 고칠점들
# 방법은 맞았는데 구현이 너무 오래걸린것 같다
# 유일성은 금방 했는데 최소성 걸러내는것이 너무 오래걸림
# 최소성 걸러내는것에서 startswith가 아니라 전체에 있냐 없냐를 판단했어야함
# tuple, set, list 형변환에 아직도 약간 어색했다 -> 시간 꽤 걸림
# 다른 사람 풀이도 보고 좀 코드를 줄이도록 하자

from itertools import combinations

# 짧은 콘테이너가 긴 콘테이너의 앞부분과 같으면 False, 아니면 True
def minimality_check(short, long):
    for i in range(len(short)):
        if not(short[i] in long):
            return True
    return False
    
def solution(relation):
    answer = 0
    M = len(relation[0])
    N = len(relation)
    
    # 유일성 파악 -> 세로로 matrix를 돌면서 파악
    unique_relations = []
    unique_row = []
    for j in range(M):
        unique_test_list = []
        for i in range(N):
            if not(relation[i][j] in unique_test_list):
                unique_test_list.append(relation[i][j])
            else:
                break
        if len(unique_test_list) == N :
            unique_relations.append((j,))
            unique_row.append(j)
    
    
    # 이제 남은 col 중에서 2개부터 총 남은 갯수까지 결합해서
    # unique 함을 만족하는지 안하는지
    # + 최소성을 만족하는지 안하는지 판단
    comb_list = []
    for i in range(M):
        if i not in unique_row:
            comb_list.append(i)
    
    # 2개부터 총 남은 갯수까지 결합을 만듬
    for i in range(2, len(comb_list)+1):
        combs = list(combinations(comb_list,i))
        
        # 이제 각 comb 별로 col을 뽑아내서 
        # 그걸로 unique 테스
        for comb in combs:
            comb_unique_reation = []
            # print(comb)
            
            unique_test = set()
            for i in range(N):
                # comb 안에 있는 것들에 대한 list를 만듬
                tmp_tuple = tuple(relation[i][j] for j in comb) # 이게 되네?
                unique_test.add(tmp_tuple)                
                
            # 다 들어갔나 숫자 세기
            if len(unique_test) == N:
                flag = True
                for i in range(len(unique_relations)):
                    flag &= minimality_check(unique_relations[i], comb)
                # 다 startswith를 했는데도 True면 최소성을 다 만족했다는 뜻 -> 키가 됨
                if flag:
                    unique_relations.append(comb)
        # -- 여기까지는 잘 작동 --
        
        # 최소성 걸러내기
        # 하나씩 돌면서 그 뒤에거가 이걸로 시작하나 하나씩 판단해야할듯?
    answer = len(unique_relations)
                
                    
    # print(unique_relations)
            
    
    
    return answer


print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]])) #2
print(solution([["a", "1", "aaa", "c", "ng"], ["a", "1", "bbb", "e", "g"], ["c", "1", "aaa", "d", "ng"], ["d", "2", "bbb", "d", "ng"]])) # 5