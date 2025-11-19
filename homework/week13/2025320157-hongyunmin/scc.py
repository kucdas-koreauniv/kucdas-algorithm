import sys
sys.setrecursionlimit(10000)

def dfs_rev(graph, visited, v):
    global f_num
    if visited[v]:
        return
    visited[v] = 1
    for b in graph[v]:
        dfs_rev(graph, visited, b)
    f.append((v, f_num))
    f_num += 1

def dfs(graph, visited, v, temp):
    if visited[v]:
        return
    temp.append(v)
    visited[v] = 1
    for b in graph[v]:
        dfs(graph, visited, b, temp)

v, e = map(int, input().split())
graph = [[] for _ in range(v + 1)]
graph_rev = [[] for _ in range(v + 1)]

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph_rev[b].append(a)

f = list()
f_num = 0
visited = [0] * (v + 1)

for i in range(1, v + 1):
    if not visited[i]:
        dfs_rev(graph_rev, visited, i)

f.sort(key=lambda x: x[1], reverse=True)

visited = [0] * (v + 1)
scc = list()
for node, time in f:
    if not visited[node]:
        temp = []
        dfs(graph, visited, node, temp)
        temp.sort()
        temp.append(-1)
        scc.append(temp)

scc.sort(key=lambda x: x[0])
print(len(scc))
for s in scc:
    for v in s:
        print(v, end=' ')
    print('')