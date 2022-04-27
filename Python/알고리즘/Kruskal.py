# 일단 uniion find의 모든 함수들이 필요함 -> 사이클인지 아닌지 판별을 위해서

# 최상위 부모를 찾는 함수
def getParent(parent, x):
    if parent[x] == x:
        return x

    parent[x] = getParent(parent, parent[x])
    return parent[x]

# 두 노드를 포함하는 그래프를 합치는 함수 -> 부모를 같게 함
def unionParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a < b :
        parent[b] = a
    else:
        parent[a] = b

# 두 노드가 부모가 같은지 다른지 판단하는 함수
def findParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)

    if a == b:
        return True
    else:
        return False

# n 은 노드 갯수, m 은 간선 갯수, edge 는 간선 정보를 담은 2차원 배열
def main(n,m, edge):

    # 간선의 비용 기준으로 오름차순 정렬
    edge.sort(key = lambda x: x[2])

    # 각 정점이 포함된 그래프가 어디인지 저장 == 최상위 부모 노드를 봄
    parent = [i for i in range(n+1)]
    
    total_distance = 0
    for i in range(len(edge)):
        # 사이클이 발생하지 않는 경우 그래프에 포함
        if not(findParent(parent, edge[i][0], edge[i][1])):
            total_distance += edge[i][2]
            unionParent(parent, edge[i][0], edge[i][1])
            
    print(total_distance)

# 간선 정보를 담는 2차원 배열 [[node, node, distance], ...]
edges = [[1, 7, 12], [1, 4, 28], [1, 2, 67], [1, 5, 17], [2, 4, 24], [2, 5, 62],
[3, 5, 20], [3, 6, 37], [4, 7, 13], [5, 6, 45], [5, 7, 73]]


main(7, 11, edges)
