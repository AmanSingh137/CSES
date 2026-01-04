#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
using namespace std;

const int MOD = 1e9 + 7;

int main() {
    int n, sum;
    cin >> n >> sum;
    vector<int> vec(n);
    for (int i = 0; i < n; i++)
    {
        cin >> vec[i];
    }
    const int MOD = 1e9 + 7;
    vector<int> dp(sum + 1, 0);
    dp[0] = 1; 
    for (int coin : vec) {
        for (int i = coin; i <= sum; i++) {
            dp[i] = (dp[i] + dp[i - coin]) % MOD;
        }
    }
    cout << dp[sum] << endl;
    return 0;
}