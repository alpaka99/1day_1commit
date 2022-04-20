import sys
sys.stdin = open("1197_최소스패닝트리.txt", 'r')


def getParent(parent, x):
    if parent[x] == x:
        return x
    
    parent[x] = getParent(parent, parent[x])
    return parent[x]


def unionParent(parent, a, b):
    pa = getParent(parent, a)
    pb = getParent(parent, b)


    if pa < pb:
        parent[pb] = pa
    else:
        parent[pa] = pb

def sameParent(parent, a, b):
    pa = getParent(parent, a)
    pb = getParent(parent, b)

    if pa == pb:
        return True
    else:
        return False




# 그래프가 주어졌을떄 최소 스패닝 트리를 구하는 프로그램


# 정점의 갯수 V, 간선의 갯수 E
V, E = map(int, input().split())

# E개의 줄에 각 간선에 대한 정보를 나타내는 세 정수 A, B, C
# 크루스칼 알고리즘
# 1. 각 간선을 weight 를 기준으로 오름차순으로 정렬
# 2. 간선을 하나씩 그래프에 더해감
# 3. 만약 간선을 더했을떄 싸이클이 생긴다면 더하지 않음

parent = [ i for i in range(V+1)]

total = 0
cnt = 1
data = []
for _ in range(E):
    tmp = list(map(int, input().split()))
    data.append(tmp)

# 1.
data.sort(key = lambda x:x[2])

for elem in data:
    a, b, w = elem
    if not(sameParent(parent, a, b)): # 3.
        unionParent(parent, a, b) # 2.
        total += w
        cnt += 1
    
    # 시간단축
    if cnt >= V:
        break
    

# 최소 스패닝트리의 가중치 출력
print(total)
    