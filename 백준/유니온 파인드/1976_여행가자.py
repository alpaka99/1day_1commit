import sys
sys.stdin = open('1976_여행가자.txt', 'r')



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
        return  True
    else:
        return False


# 총 도시의 수 N, 여행 계획에 속한 도시의 수 M
N = int(input())
M = int(input())

# 여행 경로가 주어졌을때, 이 여행경로가 가능한지

cities = [i for i in range(N+1)]

# 총 N 줄의 도시들 간의 연결 정보 N개가 주어짐
matrix = []

# unionfind 로 그래프 연결
for i in range(N):
    tmp = list(map(int, input().split()))
    for j in range(N):
        if tmp[j]:
            unionParent(cities, i+1, j+1)


# 마지막 줄에는 여행 계획
data = list(map(int, input().split()))

flag = True
for i in range(len(data)-1):
    if sameParent(cities, data[i], data[i+1]):
        continue
    else:
        flag = False
        break

if flag:
    print("YES")
else:
    print("NO")

# YES