#include <iostream>
#include <vector>
using namespace std;

int solve(vector<vector<int>>& a, int i, vector<int>& vis, int n, vector<vector<int>>& dp) {
    if (i >= n-1) return 0;
    int x = a[i][0], y = a[i][1];
    if (vis[x]==1 || vis[y]==1) return dp[i][0]=solve(a, i+1, vis, n, dp);
    if (dp[i][0]==-1) dp[i][0] = solve(a, i+1, vis, n, dp);
    if (vis[x]==0 && vis[y]==0) {
        vis[x]=1;
        vis[y]=1;
        if (dp[i][1] == -1) dp[i][1] = max(dp[i][0], 1+solve(a, i+1, vis, n, dp));
        vis[x]=0;
        vis[y]=0;
    }
    return max(dp[i][0], dp[i][1]);
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
    vector<vector<int>> dp(n+1, vector<int>(2, -1));
    int ans = solve(vec, 0, vis, n, dp);
    cout << ans;
    return 0;
}