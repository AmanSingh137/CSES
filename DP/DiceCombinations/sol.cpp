#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

const int MOD = 1e9 + 7;

long long solve(int dice[], int sum, vector<long long>& dp) {
    if (sum < 0) return 0;
    if (sum == 0) return 1;
    if (dp[sum] !=-1) return dp[sum];
    long long cnt = 0;
    for (int i = 0; i < 6; i++) {
        if (dice[i] <= sum) {
            cnt = (cnt +solve(dice, sum - dice[i], dp))%MOD;
        }
    }
    return dp[sum] = cnt;
}

int main() {
    int n;
    cin >> n;
    vector<long long> dp(n+1, -1);
    dp[1]=1;
    int dice[6] = {1, 2, 3, 4, 5, 6};
    cout << solve(dice, n, dp) << endl;
    return 0;
}