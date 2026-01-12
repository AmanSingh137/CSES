#include <iostream>
#include <vector>
using namespace std;

void dfs1(int root, int parent, vector<long long>& dp
    , vector<long long>& sub, vector<vector<int>>& adj) {
    sub[root]=1;
    dp[root]=0;
    for (int v : adj[root]) {
        if (v==parent) continue;
        dfs1(v, root, dp, sub, adj);
        sub[root] += sub[v];
        dp[root] += dp[v]+sub[v];
    }
}

void dfs2(int root, int parent, vector<long long>& dp,
    vector<long long>& sub, vector<long long>& ans, vector<vector<int>>& adj, int n) {
    for (int v : adj[root]){
        if (v==parent) continue;
        ans[v] = ans[root] - sub[v] + (n-sub[v]);
        dfs2(v, root, dp, sub, ans, adj, n);
    }
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> adj(n+1);
    for (int i = 0; i < n-1; i++) {
        int x, y;
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    vector<long long> dp(n+1, 0), ans(n+1, 0), sub(n+1, 0);
    dfs1(1, -1, dp, sub, adj);

    ans[1]=dp[1];
    dfs2(1, -1, dp, sub, ans, adj, n);
    for (int i = 1; i <= n; i++) {
        cout << ans[i] << " ";
    }
    return 0;
}