# LIS : 최장 증가 부분 수열
# -> 주어진 수열 중에서 수가 증가하도록 선택해서 만든 수열
from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))
std_arr = []
# LIS 길이를 찾기 위한 리스트(실제 LIS는 아님)
dp = [1] * n
# LIS 길이를 저장해둔 리스트
# i번째 수를 끝으로 하는 LIS의 최대 길이가 저장됨
# 최소 LIS 길이는 1

for i, v in enumerate(arr) :
    idx = bisect_left(std_arr, v) # 오름차순 기준으로 v를 삽입할 인덱스를 알려줌

    if idx >= len(std_arr) : # 마지막 수보다도 더 큰 수가 들어온다면
        std_arr.append(v) # 맨 끝에 삽입하는 거
        dp[i] = len(std_arr) # arr의 i번째 수가 갖는 LIS 길이 업데이트

    else : # 마지막 수보다 크지 않은 수가 들어온다면 
        std_arr[idx] = v
        # 해당 인덱스의 값을 (더 작은 수로) 바꿔치기(그래야 다음 i에서 LIS 선택의 폭이 넓어지는 걸 반영 가능)
        dp[i] = idx + 1
        # 이 수가 갖는 LIS 길이는 삽입 인덱스랑 똑같음(인덱스는 0부터 시작이니까 1 더한거)

print(max(dp))