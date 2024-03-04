def solution(nums):
    # 총 폰켓몬 개수
    total_cnt = len(nums)
    # 중복 제거를 위한 set 사용
    nums = set(nums)
    
    # 중복 없는 개수가 N/2 보다 적거나 같을 때
    if total_cnt // 2 <= len(nums):
        answer = total_cnt // 2
    # 중복 없는 개수가 N/2 보다 많을 때
    else:
        answer = len(nums)
        
    
    return answer