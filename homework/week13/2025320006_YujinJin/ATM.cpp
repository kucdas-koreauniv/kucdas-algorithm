#include <iostream>
#include <vector>
#include <stack>
#include <array>
#include <algorithm>
#include <queue>
#include <unordered_set>
using namespace std;

array<bool, 500001> visit;
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

struct supernode {
    vector<int> node;
    int price;
    int indegree;
    int outdegree;
    bool rest;
};


int main() {
    // <1> SCC 구성
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


    // 전처리
    // 1) 각 '원래 노드'의 price 입력
    vector<int> price(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> price[i];
    }

    // 2) 시작 노드 s, 레스토랑 정보
    int s, p;
    cin >> s >> p;

    vector<int> is_rest(n + 1, 0);
    for (int i = 0; i < p; i++) {
        int r;
        cin >> r;
        is_rest[r] = 1;   // r번 노드가 레스토랑
    }

    // <2> 노드 엮어서 supernode 그래프 만들기
    int v = groups.size();            // supernode 개수
    vector<supernode> s_graph(v);     // ★ 포인터 말고 그냥 객체 벡터

    // node -> supernode(그룹) 번호 매핑
    vector<int> comp(n + 1, -1);

    for (int i = 0; i < v; i++) {
        s_graph[i].node = groups[i];   // 이 supernode 안에 들어있는 노드들
        s_graph[i].price = 0;
        s_graph[i].rest = false;
        s_graph[i].indegree = 0;
        s_graph[i].outdegree = 0;

        for (int x : groups[i]) {
            comp[x] = i;               // x번 노드는 i번 supernode에 속함
            s_graph[i].price += price[x];
            if (is_rest[x]) s_graph[i].rest = true;
        }
    }

    // supernode 간 DAG 만들기
    vector<vector<int>> dag(v);

    for (int u = 1; u <= n; u++) {
        for (int vtx : graph[u]) {
            int a = comp[u];
            int b = comp[vtx];
            if (a == b) continue;      // 같은 SCC 내부는 무시
            dag[a].push_back(b);
        }
    }

    // 중복 간선 제거 + indegree / outdegree 계산
    for (int i = 0; i < v; i++) {
        auto &adj = dag[i];
        sort(adj.begin(), adj.end());
        adj.erase(unique(adj.begin(), adj.end()), adj.end());

        s_graph[i].outdegree = (int)adj.size();
    }

    for (int i = 0; i < v; i++) {
        for (int nxt : dag[i]) {
            s_graph[nxt].indegree++;
        }
    }

    // 위상정렬 + DP

    int start = comp[s];               // s가 속한 supernode

    // dp[u] : s에서 시작해서 u(supernode)까지 올 때 얻을 수 있는 최대 가격
    vector<long long> dp(v, -1);
    dp[start] = s_graph[start].price;

    // 위상정렬
    queue<int> q;
    vector<int> indeg(v);
    for (int i = 0; i < v; i++) indeg[i] = s_graph[i].indegree;

    for (int i = 0; i < v; i++) {
        if (indeg[i] == 0) q.push(i);
    }

    while (!q.empty()) {
        int u = q.front(); q.pop();

        for (int nxt : dag[u]) {
            if (dp[u] != -1) {
                dp[nxt] = max(dp[nxt],
                              dp[u] + (long long)s_graph[nxt].price);
            }
            if (--indeg[nxt] == 0) q.push(nxt);
        }
    }

    long long ans = 0;
    for (int i = 0; i < v; i++) {
        if (s_graph[i].rest && dp[i] != -1) {
            ans = max(ans, dp[i]);
        }
    }

    cout << ans << '\n';

    return 0;
}