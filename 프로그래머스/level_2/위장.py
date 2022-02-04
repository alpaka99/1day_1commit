# 정답은 맞았는데 시간초과가 나네
# from itertools import combinations
# 조합으로 모든 경우의 수를 계산하는 경우에 정답은 맞았지만 시간 초과가 났음
# -> 생각을 뒤집어서 해야하는 문제였다!!!!!!!!!
# 예전 통계시간에 배운 전체 경우 -1 의 방법을 사용해서 풀어야하는 문제였다

def solution(clothes):
    answer = 1
    
    clothes_dict = {} # 아이템을 저장할 dict
    
    # 아이템들을 카테고리별로 분류
    for elem in clothes:
        item, category = elem
        if clothes_dict.get(category) == None:
            clothes_dict[category] = [item]
        else:
            clothes_dict[category].append(item)
    
    
    keys = clothes_dict.keys()
    
    # 모든 카테고리의 조합을 겹치지 않게 구하고
    # 생각을 바꿔서 전체에서 옷을 다 안입는 경우만 뺸다
    # -> (해당 카테고리 아이템의 갯수 + 카테고리의 옷을 안입은 경우)
    for elem in keys:
        answer *= (len(clothes_dict[elem])+1)
    
    # 다 안입은 경우는 제외해줌
    answer -= 1
    
    return answer


print(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]])) # 5
print(solution([["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]])) # 3