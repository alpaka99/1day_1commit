# 특정한 노드의 부모를 찾는 함수
def getParent(parent, x):
    # 만약 x 라는 값이 해당 노드의 부모값과 같으면 x 를 반환
    # 재귀함수의 종료 부분
    if (parent[x] == x) : 
        return x
    
    # 만약 자기자신과 부모 노드가 다르다면,
    # 실제 부모를 찾기 위해 재귀적으로 들어감
    parent[x] = getParent(parent, parent[x])

    return parent[x]

# 두 부모 노드를 합치는 함수
def unionParent(parent, a, b):
    # a 와 b  각각의 부모 노드를 구한 후
    a = getParent(parent, a)
    b = getParent(parent, b)

    # 더 작은 값을 부모 노드로 만듬
    if a < b :
        parent[b] = a
    else:
        parent[a] = b
    
    return

# 같은 부모를 가지는지 확인하는 함수
# -> 같은 그래프에 속해있는지 확인하는 함수
def findParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a == b:
        return True
    else:
        return False

def main():
    parent = [ i for i in range(11)]
    unionParent(parent, 1, 2)
    unionParent(parent, 2, 3)
    unionParent(parent, 3, 4)
    unionParent(parent, 5, 6)
    unionParent(parent, 6, 7)
    unionParent(parent, 7, 8)

    print(parent)
    print(f"1 과 5는 연결되어있나요?{findParent(parent, 1, 5)}")


    unionParent(parent, 1, 5)
    print(parent)
    print(f"1 과 5는 연결되어있나요?{findParent(parent, 1, 5)}")


main()