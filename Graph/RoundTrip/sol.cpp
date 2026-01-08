#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector <int> parent;
vector <int> vis;
vector <int> cycle;
bool fl = false;

void dfs(vector<vector<int>>& adj, int i, int p) {
    if (fl) return;
    parent[i]=p;
    vis[i]=1;
    for (int a : adj[i]) {
        if (a==p) continue;
        if (vis[a]==-1) {
            dfs(adj, a, i);
            if (fl) return;
        } else {
            fl = true;
            cycle.push_back(a);
            int k = i;
            while (k != a) {
                cycle.push_back(k);
                k = parent[k];
            }
            cycle.push_back(a);
            return;
        }
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
    for (int i = 0; i <= n; i++) {
        vis.push_back(-1);
        parent.push_back(-1);
    }
    for (int i = 1; i <= n; i++) {
        if (vis[i]==-1) {
            dfs(adj, i, -1);
            if (fl) break;
        }
    }
    if (!fl) {
        cout << "IMPOSSIBLE" << endl;
        return 0;
    }
    int l = cycle.size();
    cout << l << endl;
    for (int i = 0; i < l; i++) {
        cout << cycle[i] << " ";
    }
    cout << endl;
    return 0;
}