# N개의 마을 ,K는 배달 최대 거리
# 각 마을의 연결은 weighted
# road는 (a, b, c)이며 a, b는 마을번호 c는 weight
# a, b 연결은 여러개 가능
# 음식점은 1번 마을에 있음
# K 이하의 시간에 배달이 가능한 마을의 갯수

# adjecent 한 matrix를 그리면 될거같은데? -> 이러면 모든 마을에 대한 weight을 넣을 수 가 없음
# 그러면 full matrix로? -> 50 x 50 = 2500 흠...

from collections import deque
        
def solution(N, road, K):
    answer = 0
    
    # full matrix 만듬
    matrix = [[-1 for _ in range(N)] for _ in range(N)]
    
    # 데이터 넣기
    for elem in road:
        a, b, c = elem
        if matrix[a-1][b-1] == -1:
            matrix[a-1][b-1] = c
            matrix[b-1][a-1] = c
        else:
            matrix[a-1][b-1] = min(matrix[a-1][b-1], c)
            matrix[b-1][a-1] = min(matrix[b-1][a-1], c)
        
    
    # 도달하는 시간을 재는 리스트 및 방문 체크
    visited = [-1 for _ in range(N)]
    visited[0] = 0
    
    # deque에서 시간이 0인 애들만 뺴내고 나머지는 다시 넣는 방법으로 가야할듯
    dq = deque()
    dq.append((0, 1)) # 처음 시작인 마을을 넣어줌
    
    time = 0
    while time <= K:
        # print("time:", time)
        size = len(dq)
        for i in range(size):
            cur_loc, cur_time = dq.popleft()
            cur_time -= 1
            if cur_time <= 0: # 마을까지 남은 시간이 0이다? -> 해당 마을에 도착했다
                # print("끝남", cur_loc+1, cur_time)
                if visited[cur_loc] == -1:
                    visited[cur_loc] = time
                else:
                    visited[cur_loc] = min(visited[cur_loc],time) # 도착시간 체크
                for i in range(N): # 해당 마을과 연결된 마을들 deque에 넣기
                    if matrix[cur_loc][i] != -1:
                        if visited[i] == -1:
                            dq.append((i, matrix[cur_loc][i]))
            else:
                dq.append((cur_loc, cur_time))
        # print(list(dq))
        time += 1
        
        
    for i in range(N):
        if visited[i] != -1:
            answer += 1
    
    # print(visited)
    return answer


print(solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3)) # 4
print(solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4)) # 4




## 다른 사람 풀이
# 모든 node를 방문 한 후 걸린 시간을 visited에 체크함
# 그리고 나서 K에 따라서 visited를 걸러내는 방법
# -> 이게 구현은 더 쉬울듯?

# 자다가 생각난 풀이
# dfs로 모든 노드를 돌고 나서 K에 따라 분류하는게 더 쉬울까?