#include <iostream>
#include <vector>
using namespace std;

int solve(vector<vector<int>>& a, int i, vector<int>& vis, int n) {
    if (i >= n-1) return 0;
    int x = a[i][0], y = a[i][1];
    if (vis[x]==1 || vis[y]==1) return solve(a, i+1, vis, n);
    int ans = solve(a, i+1, vis, n);
    if (vis[x]==0 && vis[y]==0) {
        vis[x]=1;
        vis[y]=1;
        ans = max(ans, 1+solve(a, i+1, vis, n));
        vis[x]=0;
        vis[y]=0;
    }
    return ans;
}

int main() {
    int n;
    cin>>n;
    vector<vector<int>> vec(n+1, vector<int>(2));
    for (int i = 0; i < n-1; i++) {
        int x, y;
        cin >> x >> y;
        vec[i][0]=x;
        vec[i][1]=y;
    }
    vector<int> vis (n+1, 0);
    int ans = solve(vec, 0, vis, n);
    cout << ans;
    return 0;
}