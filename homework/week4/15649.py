from itertools import permutations

n, m = map(int, input().split())
number_list = []

for i in range(1, n+1):
    number_list.append(i)

for i in permutations(number_list, m):
    print(*i)