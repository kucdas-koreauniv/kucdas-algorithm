n = int(input())
arr = list(map(int, input().split()))
sum = list(arr) #그냥 sum = arr 하면 참조 복사(같은 주소 가리킴)

for i in range(n-1, -1, -1) :
    v = arr[i]
    max_sum = 0
    for j in range(i+1, n) :
        if arr[j] > v and sum[j] > max_sum :
            max_sum = sum[j]
    sum[i] += max_sum

print(max(sum))