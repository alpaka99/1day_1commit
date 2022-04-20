# N 개국을 여행
# 최대한 적은 종류의 비행기를 타고 국가 이동
# 모든 국가들을 가장 적은 종류의 비행기를 타고 이동하게끔

def getParent(parent, x):
    if parent[x] == x:
        return x
    
    parent[x] = getParent(parent, parent[x])
    return parent[x]

def unionParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def findParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a == b:
        return True
    else:
        return False

import sys
sys.stdin = open("9372_상근이의여행.txt", 'r')

T = int(input())

for tc in range(T):
    # 국가의 수 N, 비행기의 종류 M
    N, M = map(int, input().split())

    countries = [i for i in range(N+1)]
    # print(countries)

    # 순서쌍 a, b : a, b 를 왕복하는 비행기
    total = 0
    for i in range(M):
        a, b = map(int, input().split())

        if not(findParent(countries, a, b)):
            unionParent(countries, a, b)
            total += 1
        
        if sum(countries) == N:
            continue

    print(total)

# 2
# 4