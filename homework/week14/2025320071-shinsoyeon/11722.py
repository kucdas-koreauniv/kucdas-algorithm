from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))
arr.reverse()
std_arr = []
dp = [1] * n

for i, v in enumerate(arr) :
    idx = bisect_left(std_arr, v)
    if idx >= len(std_arr) :
        std_arr.append(v)
        dp[i] = len(std_arr)
    else :
        std_arr[idx] = v
        dp[i] = idx + 1

print(max(dp))