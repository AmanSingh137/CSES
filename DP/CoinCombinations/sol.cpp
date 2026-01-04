#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;

const int MOD = 1e9 + 7;

int solve(int sum, vector<int>& vec, vector<int>& dp){
    if (sum < 0) return 0;
    if (sum ==0) return 1;
    if (dp[sum] != -1) return dp[sum];
    long long ans = 0;
    for (int i = vec.size()-1; i >= 0; i--) {
        ans =(ans+solve(sum-vec[i], vec, dp))%MOD;
    }
    return dp[sum] = ans;
}


int main() {
    int n, sum;
    cin >> n >> sum;
    vector<int> vec(n);
    vector<int> dp(sum+1, -1);
    for (int i = 0; i < n; i++)
    {
        cin >> vec[i];
    }
    cout << solve(sum, vec, dp)<< endl;
}