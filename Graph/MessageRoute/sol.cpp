#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

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
    vector<int> ans;
    vector<int> vis(n+1, 0);
    vector<int> parent(n+1, 0);
    queue<int> q;
    q.push(1);
    vis[1]=1;
    int fl = 0, len = 0;
    while(!q.empty()) {
        int a = q.front();
        q.pop();
        if (a==n) {
            fl = n;
            break;
        }
        for (int node: adj[a]) {
            if (vis[node]==1) continue;
            if (vis[node]==0) {
                vis[node]=1;
                q.push(node);
                parent[node]=a;
            }
        }
    }
    if (!fl) {
        cout << "IMPOSSIBLE" << endl;
        return 0;
    }
    int k = n;
    ans.push_back(n);
    len++;
    while (parent[k]!=1) {
        k = parent[k];
        ans.push_back(k);
        len++;
    }
    ans.push_back(1);
    reverse(ans.begin(), ans.end());
    int l1 = ans.size();
    cout << l1  << endl;
    for (int i = 0; i < l1; i++) {
        cout << ans[i] << " ";
    }
    return 0;
}