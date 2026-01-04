#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;

const int MOD = 1e9 + 7;

int solve(int sum, vector<int>& vec, vector<int>& dp){
    if (sum < 0) return INT_MIN;
    if (sum ==0) return 0;
    if (dp[sum] != -4) return dp[sum];
    int ans =INT_MAX;
    for (int i = vec.size()-1; i >= 0; i--) {
        if (vec[i] <= sum) {
            int k = (1+solve(sum-vec[i], vec, dp))%MOD;
            if (k>0) {
                ans = min(ans, k);
            }
        }

    }
    return dp[sum]= ans==INT_MAX ? -1 : ans;
}


int main() {
    int n, sum;
    cin >> n >> sum;
    vector<int> vec(n);
    vector<int> dp(sum+1, -4);
    for (int i = 0; i < n; i++)
    {
        cin >> vec[i];
    }
    sort(vec.begin(), vec.end());
    cout << solve(sum, vec, dp)<< endl;
}