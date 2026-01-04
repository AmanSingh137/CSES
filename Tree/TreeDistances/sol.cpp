#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int bfs (int start, vector<vector<int>>& tree, vector<int>& dist) {
    queue<int> q;
    q.push(start);
    int mx = start;
    dist[start]=0;
    int ans = 0;
    while (!q.empty()) {
        int a = q.front();
        q.pop();
        mx = a;
        for (int i : tree[a]) {
            if (dist[i]==-1) {
                dist[i]=dist[a]+1;
                q.push(i);
                ans = max(ans, dist[i]);
            }
        }
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> tree(n+1);
    for (int i = 0; i < n-1; i++) {
        int x, y;
        cin >> x >> y;
        tree[x].push_back(y);
        tree[y].push_back(x);
    }
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
        vector<int> dist(n+1, -1);
        int k = bfs (i, tree, dist);
        ans.push_back(k);
    }
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    return 0;
}