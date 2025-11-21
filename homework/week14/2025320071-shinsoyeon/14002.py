#14003도 동일
from bisect import bisect_left
from collections import deque

n = int(input())
arr = list(map(int, input().split()))
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

max_len = len(std_arr)
max_idx = -1

for i in range(n - 1, -1, -1):
    if dp[i] == max_len:
        max_idx = i
        break

search_v = arr[max_idx]
lis = deque([search_v])
search_len = max_len - 1

for i in range(max_idx -1, -1, -1):
    v = arr[i]
    if search_len == dp[i] and v < search_v:
        lis.appendleft(v)
        search_v = v
        search_len -= 1
    if search_len == 0 :
        break

print(max_len)
print(*list(lis))