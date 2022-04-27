# 모든 단어를 만들어낸 후 사전 순 정렬 -> Python에서는 string 정렬이 사전순 정렬
# 그러고 나서 위치를 찾으면 될 것 같긴 함
# EIO랑 I랑은 어떤게 앞에 올지 어캐구분? -> 그냥 해도 될 것 같긴 한데 EIOZZ 랑 IZZZZ로 해도 될 듯
# -> 그냥 해도 되긴 하네. 결국엔 모든 단어를 어캐 만들지가 관건
# permutaion은 중복해서 뽑지를 않네 흠... 같은 글자를 중복해서 뽑는 경우도 해야하는디
# -> 이거를 cartesian product(곱집합)이라고 함

from itertools import product

def solution(word):
    answer = 0
    word_list = []
    AEIOU = ["A", "E", "I", "O", "U"]
    for i in range(1, 6):
        cartesian_product = list(map(''.join, product(AEIOU, repeat=i)))
        word_list.extend(cartesian_product)
    
    word_list.sort()
    
    for i in range(len(word_list)):
        if word_list[i] == word:
            return i+1
    return answer