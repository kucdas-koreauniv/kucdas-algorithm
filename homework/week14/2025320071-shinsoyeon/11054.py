from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))

def series_len(array) :
    std_arr = []
    dp = [1] * n    
    for i, v in enumerate(array) :
        idx = bisect_left(std_arr, v)
        if idx >= len(std_arr) :
            std_arr.append(v)
            dp[i] = len(std_arr)
        else :
            std_arr[idx] = v
            dp[i] = idx + 1
    return dp

LIS = series_len(arr)
LDS = series_len(list(reversed(arr)))
LDS.reverse()

max_len = 0
for i in range(n) :
    bitonic_len = LIS[i] + LDS[i]
    if bitonic_len > max_len :
        max_len = bitonic_len

print(max_len - 1)  # dp의 초기값 1이 두 번 더해졌기 때문