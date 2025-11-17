import sys
sys.setrecursionlimit(10000)

def dfs(node = int) :
    visit[node] = True
    for neighbor in graph[node] :
        if not visit[neighbor] :
            dfs(neighbor)
    stack.append(node)

def rv_dfs(node = int) :
    visit[node] = True
    groups[-1].append(node)
    for neighbor in rv_graph[node] :
        if not visit[neighbor] :
            rv_dfs(neighbor)

n, m = map(int, input().split())

graph = [[] for _ in range (n + 1)]     #인덱스가 1부터 시작해서..
rv_graph = [[] for _ in range (n + 1)]

visit = [False] * (n + 1)
stack = []

for i in range(m) :
    u, v = map(int, input().split())
    graph[u].append(v)
    rv_graph[v].append(u)

    graph[u].sort()
    rv_graph[v].sort()

for i in range (1, n + 1) :
    if not visit[i] :
        dfs(i)

visit = [False] * (n + 1)
groups = []

while stack :
    node = stack.pop()
    if not visit[node] :
        groups.append([])
        rv_dfs(node)

print(len(groups))
groups.sort(key=lambda x : min(x))
for i in groups :
    print(*(sorted(i) + [-1]), sep=" ")