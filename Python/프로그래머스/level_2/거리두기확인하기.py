#  https://programmers.co.kr/questions/20609

# 1. 사람이 앉은 자리 + 사방에 -1을 해줌
# 2. 칸막이가 있는 곳에는 +10(3 이상의 숫자 아무거나)를 해줌
# 3. 전체를 돌면서 -2 이하의 수가 있으면 거리두기를 안지킨거


def check(matrix):
    for i in range(5):
            for j in range(5):
                if matrix[i][j] <= -2:
                    return 0
                
    return 1

def solution(places):
    answer = []
    
    for place in places:
        matrix = [[0 for _ in range(5)] for _ in range(5)]
        
        ps = []
        xs = []
        
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    ps.append((i,j))
                elif place[i][j] == "X":
                    xs.append((i,j))
        
        # # 북 -> 동 -> 남 -> 서
        # dr = [-1, -1, 0, 1, 1, 1, 0, -1]
        # dc = [0, 1, 1, 1, 0, -1, -1, -1]
        
        # 앉은자리 + 사방
        dr = [0, 0, 1, 0, -1]
        dc = [0, 1, 0, -1, 0]
        
                    
        for p in ps:
            px, py = p
            for i in range(5):
                nr = px + dr[i]
                nc = py + dc[i]
                
                if not(0<=nr<5 and 0<=nc<5):
                    continue
                    
                
                matrix[nr][nc] -= 1
            
        for x in xs:
            xx, xy = x
            matrix[xx][xy] += 10
        
        answer.append(check(matrix))
        
        
        
    return answer