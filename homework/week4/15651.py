n, m = map(int, input().split())
number_list = []
print_list = []

for i in range(1, n+1):
    number_list.append(i)

def recursion(count):
    for i in range(n):
        print_list.append(number_list[i])
        if count > 1:
            recursion(count - 1)
        else:
            print(*print_list)
        print_list.pop()

recursion(m)