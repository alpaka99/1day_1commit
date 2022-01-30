# 방법 1. recursive한 dfs 함수를 짜서 했음
# -> 정답은 다 맞았으나 시간초과에 걸림

# 방법 2. bfs를 해봐야겠다
# -> deque를 이용한 bfs, 그리고 함수를 여러번 호출하지 않고 한번 호출로 끝냄
# 정답!


################################# 방법 1 #############################
min_val = 100 * 100

# delta
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


def dfs(maps, visited, n, m, r, c, steps):
    global min_val, dr, dc

    # 탈출조건
    if r == n - 1 and c == m - 1:
        min_val = min(min_val, steps)

    # 백트랙킹
    if steps >= min_val:
        return

    # 사방을 둘러보고 갈 수 있는 칸으로 이동
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        # 범위 밖
        if not (0 <= nr < n and 0 <= nc < m):
            continue

        # 이동가능한 칸이면
        if maps[nr][nc] == 1 and visited[nr][nc] == 0:
            visited[nr][nc] = 1
            dfs(maps, visited, n, m, nr, nc, steps + 1)
            visited[nr][nc] = 0


def solution1(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])

    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[0][0] = 1

    dfs(maps, visited, n, m, 0, 0, 1)

    global min_val

    if min_val == 100 * 100:
        return -1

    answer = min_val

    return answer


print(solution1([[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]]))  # -1
