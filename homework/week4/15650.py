from itertools import permutations

n, m = map(int, input().split())
number_list = []
check = True

for i in range(1, n+1):
    number_list.append(i)

for i in permutations(number_list, m):
    check = True
    for p in range(m):
        for q in range(p+1, m):
            if i[p] >= i[q]:
                check = False
                break
        if not check:
            break
    if check:
        print(*i)