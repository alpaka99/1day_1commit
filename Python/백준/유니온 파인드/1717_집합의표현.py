import sys
sys.stdin = open("1717_집합의표현.txt", 'r')
sys.setrecursionlimit(10**5) # 미친 백준 recusionlimit 1000 번 밖에 안잡아놓고 문제는 그것보다 더 재귀 많이 쓰게 만들어놓음

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

def sameParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a == b:
        return True
    else:
        return False


# 0, 1, 2, ... , n  총 n+1 개의 집합을 이루고 있음
# 합집합 연산과 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산

# n 은 각각 개별 원소들, n 은 입력으로 주어지는 연산의 개수
n, m = map(int, input().split())

parent = [i for i in range(n+1)]

# m 줄에 각각의 연산
# 합집합은 0 a, b 의 형태로 주어짐
# 1, a, b 두 원소가 같은 집합에 포함되어있는지 확인하는 연산
# -> 해당 연산에 대해 YES/NO 출력
for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        unionParent(parent, a, b)
    elif op == 1:
        if sameParent(parent, a, b):
            print("YES")
        else:
            print("NO")
    else:
        print("incorrect operator")