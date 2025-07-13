def gcd(large, small):      # 최대공약수를 구하는 유클리드 호제법
    rest = large % small
    if rest == 0:
        return small
    else:
        return gcd(small, rest)


n = int(input())    # 여기서부터 main
input_list = []
for t in range(n):
    input_list.append(list(map(int, input().split())))

for i in range(n):
    max_gcd = 1
    num_list = input_list[i]
    num_list.sort(reverse=True)
    pair_list = []
    for j in range(len(num_list)-1):
        for k in range(1, len(num_list)-j):
            pair_list.append([num_list[j], num_list[j+k]])

    for pair in pair_list:
        t_gcd = gcd(pair[0], pair[1])
        if t_gcd > max_gcd:
            max_gcd = t_gcd
    print(max_gcd)
