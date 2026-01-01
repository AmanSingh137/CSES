#include <iostream>
#include <vector>
using namespace std;

void dfs(int node, vector<int>& vis, vector<vector<int>>& adj) {
    if (vis[node]==1) return;
    vis[node]=1;
    for (auto i : adj[node]) {
        dfs(i, vis, adj);
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> adj(n+1);
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    vector<int> vis (n+1, 0);
    vector<int> ans;
    for (int i =1; i <= n; i++) {
        if (vis[i]==0) {
            ans.push_back(i);
            dfs(i, vis, adj);
        }
    }
    int k = ans.size();
    cout << k - 1<< endl;
    for (int i = 1; i < k; i++) {
        cout << ans[i-1] << " " << ans[i] << endl;
    }
    return 0;
}