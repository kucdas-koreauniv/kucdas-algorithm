#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> arr = vector<int>(n+1);
    vector<int> dp = vector<int>(n+1);
    arr[0] = 0;
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 1; i < n+1; ++i) {
        cin >> arr[i];
    }

    for (int i = 2; i < n+1; ++i) {
        for (int j = 0; j < i; ++j) {
            if (arr[j] < arr[i]) dp[i] = max(dp[i], dp[j]+1);
        }
    }

    int ret = 0;
    for (auto elem : dp) {
        if (elem > ret) ret = elem;
    }
    
    cout << ret << "\n";

    return 0;
}