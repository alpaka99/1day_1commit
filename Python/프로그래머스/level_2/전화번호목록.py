# 1. 처음에 틀린 이유 
# -> 짧은 숫자 in 긴 숫자 를 해서 접두사가 아니라 중간에 있을떄도 False를 반환해버림

# 2. 두번째 시간초과
# string 배열을 sort 하면 string의 앞에서부터 값이 작은대로 정렬됨
# 이것을 이용해서 앞에꺼가 뒤에꺼의 접두사인지 아닌지를 판단 계속하면
# for문 1개만 이용해서도 풀 수 있음

def solution(phone_book):
    phone_book.sort()
    
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
                return False
            
    return True


print(solution(["119", "97674223", "1195524421"])) # False
print(solution(["123", "456", "789"])) # True
print(solution(["12", "123", "1235", "567", "88"])) # True