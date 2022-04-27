# 1. cpp, java, python 중 1개 -> lang_dict
# 2. backend, frontend -> work_dict
# 3. junior, senior -> career_dict
# 4. chicken, pizza -> food_dict
# 5. 코딩테스트 점수

# 해당 조건에 맞는 지원자가 몇명인지 쉽게 구하고 싶음
# 지원자는 1에서 5000명 -> 5000명을 다 뒤지기에는 많지 않을까?
# tree로 나눠서 하는건 별로일까? -> 상위 조건을 스킵하면 좀 애매할듯
# dictionary로 일일이 다 나누는 hashing으로 하는게 괜찮을까?


def solution(info, query):
    answer = []
    
    # 거꾸로 dict들을 만들어서 해야겠다
#     # 4 
#     food_dict = {"chicken":{}, "pizza":{}}
    
#     # 3
#     career_dict = {"junior":{}, "senior":{}}
    
#     # 2
#     work_dict = {"backend":{}, "frontend":{}}
    
#     # 1
#     user_dict = {"java":{}, "cpp":{}, "python": {}}
    
    user_dict = {}
    #  -> 그냥 입력 받으면서 술술 만들어지는 방법으로는 안될까?
    for data in info:
        user_data = list(data.split())
        
        cur_dict = user_dict
        
        for i in range(3):
        # 0 ~ 3
            if cur_dict.get(user_data[i]) == None:
                cur_dict[user_data[i]] = {}
            cur_dict = cur_dict[user_data[i]]
        
        if cur_dict.get(user_data[3]) == None:
            cur_dict[user_data[3]] = []
        cur_dict[user_data[3]].append(user_data[4])
    
    print(user_dict)
    #### 여기까지 dict 완성 -> hashing ###
    
    for elem in query:
        keys = list(elem.replace("and",'').split())
        
        dict_list = [user_dict]
        
#         for i in range(4):
#             key = keys[i]
#             if key == "-":
#                 for i in range(len(dict_list)):
#                     cur_dict = dict_list[i]
#                     for key in cur_dict.keys():
#                         dict_list.append(cur_dict[key])
#             else:
#                 for i in range(len(dict_list)):
#                     dict_list[i] = dict_list[i][key]
        
        
        
    return answer