#include <iostream>
#include <vector>
#include <stack>
#include <array>
#include <algorithm>
using namespace std;

array<bool, 10001> visit;
stack<int> stk;

void dfs(int node, vector<vector<int>> *graph) {
    visit[node] = true;

    for (int nextnode : (*graph)[node]) {
        if (visit[nextnode]) continue;
        dfs(nextnode, graph);
    }

    stk.push(node);
}

void rv_dfs(int node, vector<vector<int>> *graph, vector<int> *group) {
    visit[node] = true;
    group -> push_back(node);

    for (int nextnode : (*graph)[node]) {
        if (visit[nextnode]) continue;
        rv_dfs(nextnode, graph, group);
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n+1);
    vector<vector<int>> rv_graph(n+1);
    visit.fill(false);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        rv_graph[b].push_back(a);
    }

    // 1. 정방향 DFS
    for (int i = 1; i <= n; i++) {
        if (!visit[i])
            dfs(i, &graph);
    }

    // 2. 역방향 DFS
    visit.fill(false);
    vector<vector<int>> groups;

    while (!stk.empty()) {
        int node = stk.top();
        stk.pop();

        if (visit[node]) continue;

        groups.emplace_back();
        rv_dfs(node, &rv_graph, &groups.back());
    }

    // 3. 각 그룹 내부 오름차순 정렬
    for (auto &group : groups) {
        sort(group.begin(), group.end());
    }

    // 4. 그룹 간 정렬 (각 그룹의 가장 작은 노드 기준)
    sort(groups.begin(), groups.end(), 
    [](const vector<int> &a, const vector<int> &b) {
        return a[0] < b[0];
    });

    // 5. 결과 출력
    cout << groups.size() << "\n";
    for (const auto &group : groups) {
        for (int node : group)
            cout << node << " ";
        cout << -1 << "\n";
    }

    return 0;
}