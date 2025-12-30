#include <iostream>
#include <vector>
#include <functional>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> vec;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        vec.push_back({x, 1});
        vec.push_back({y, -1});
    }
    
    sort(vec.begin(), vec.end());
    int cur = 0, ans = 0;
    for (int i = 0; i < 2*n; i++) {
        cur += vec[i].second;
        ans = max(cur, ans);
    }
    cout << ans;
    return 0;
}