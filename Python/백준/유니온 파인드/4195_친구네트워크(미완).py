import sys
sys.stdin = open('4195_친구네트워크.txt', 'r')

# 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇명이 있는지
# 친구 네트워크 == 친구 관계 만으로 이동할 수 있는 사이

def getParent(parent, x):
    if parent[x] == x:
        return x
    
    parent[x] = getParent(parent, parent[x])
    return parent[x]

def unionParent(parent, a, b):
    pa = getParent(parent, a)
    pb = getParent(parent, b)
    if pa<pb:
        parent[pb] = pa
        keys = list(names.keys())
        for key in keys:
            if names[key] == pb:
                names[key] = pa
    else:
        parent[pa] = pb
        keys = list(names.keys())
        for key in keys:
            if names[key] == pb:
                names[key] = pa

def sameParent(parent, a, b):
    pa = getParent(parent, a)
    pb = getParent(parent, b)

    if pa == pb:
        return True
    else:
        return False


# 첫줄에는 테케
tc = int(input())

for _ in range(tc):
    # 친구 관계의 수 F < 100,000 -> 값이 꽤 크니까 union find
    F = int(input())

    # 친구 관계가 생긴 순서대로 주어짐
    # 친구 관계가 생길때 마다 두 사람의 친구 네트워크에 몇명이 있는지 구하라
    # names 라는 dict 에다가 key 를 이름으로 저장해 놓고 value 가 일치하는 놈들 몇명인지 구해야할듯
    # value 의 기준은 사전순으로 가장 앞인 녀석
    names = {}
    data = []
    for __ in range(F):
        data.append(list(input().split()))

    for elem in data:
        for name in elem:
            if names.get(name) == None:
                names[name] = name
    
    keys = list(names.keys())

    for dt in data:
        a, b = dt
        unionParent(names, a, b)
        min_name = names[a]
        name_values = list(names.values())
        print(name_values.count(min_name))

        
